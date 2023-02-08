import { AfterViewInit, Component, Input, SimpleChanges } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from "../api.service";
import { DialogRackComponent } from '../dialog-rack/dialog-rack.component';
import { Racks } from '../racks.mode';
import { Warehouses } from '../warehouses.mode';
import { MatDialogModule, MatDialog, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-warehouse',
  templateUrl: './warehouse.component.html',
  styleUrls: ['./warehouse.component.css']
})
export class WarehouseComponent implements AfterViewInit {

  newRow:  boolean = true;
  id : number | undefined;
  racks: Racks[] = [];
  title = 'Almacen';
  @Input()
  public row: Warehouses | undefined;

  displayedColumns: string[] = ['id', 'type', 'actions'];

  constructor(private backend: ApiService,
              private router: Router, 
              private route: ActivatedRoute,
              public dialog: MatDialog) { }

  ngAfterViewInit(): void {
    this.route.params.subscribe(params => {
      this.id = params['id'];
      });
      console.log(this.id);
      if(this.id!=undefined){
        this.backend.getWarehouse(this.id).subscribe(res => {
          this.row = res as any;
          this.newRow = false;
        });
        this.backend.getRacks(this.id).subscribe(res=> {
          this.racks = res as any;
        });
      }
  }

  save() {
     if (!this.row || !this.row.id || !this.row.family || !this.row.size) {
       alert('Faltan datos');
     } else {
      if (this.newRow) {
        this.backend.postWarehouse(this.row).subscribe({
          next: (result) => {
            this.row = result as any;
            this.newRow = false;
          },
          error: (error) => {
            alert(error.message);
          }
          
        });
      } else {
        this.backend.putWarehouse(this.row).subscribe({
          next: (result) => {
            this.row = result as any;
            this.newRow = false;
          },
          error: (error) => {
            alert(error.message);
          }
          
        });
      }
    }
    
   
  }

  delete() {
    if(this.row!=undefined && this.row.id!=undefined){
      this.backend.deleteWarehouse(this.row.id).subscribe({
        next: (result) => {
          this.router.navigate(['/home'], { });
        },
        error: (error) => {
          alert(error.message);
        }
      });
    }
  }

  deleteRark(id: number) {
    this.backend.deleteRacks(id).subscribe({
      next: (result) => {
        if (this.row!=undefined) {
          this.backend.getRacks(this.row.id).subscribe(res=> {
            this.racks = res as any;
          });
        }
      },
      error: (error) => {
        alert(error.message);
      }
    });
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(DialogRackComponent, {
      data: {id: null, type: null},
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result.id && result.type) {
        let racks: Racks = new Racks();
        racks.id = result.id;
        racks.type = result.type;
        racks.warehouseId = this.row?.id;
        this.backend.postRacks(racks).subscribe({
          next: (result) => {
            this.backend.getRacks(result.warehouseId).subscribe(res=> {
              this.racks = res as any;
            });
          },
          error : (error) => {
            if (error.status == 409) {
              alert("Tipo incompatible");
            } else {
              alert(error.message);
            }
          }
        });
      } else {
        alert('Faltan datos');
      }
        

      });

  }

  back() {
    this.router.navigate(['/home'], { });
  }

  idChanged(newValue : string) {
    if (!this.row) {
      this.row = new Warehouses();
    } 
    this.row.id = +newValue;
  }  

  clientChanged(newValue : string) {
    if (!this.row) {
      this.row = new Warehouses();
    } 
    this.row.client = newValue;
  }

  sizeChanged(newValue : string) {
    if (!this.row) {
      this.row = new Warehouses();
    }
    this.row.size = +newValue;
  }

  familyChanged(newValue : string) {
    if (!this.row) {
      this.row = new Warehouses();
    }
    this.row.family = newValue;
  }
    

}
