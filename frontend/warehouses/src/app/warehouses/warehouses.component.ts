import { AfterViewInit, Component } from '@angular/core';
import { Warehouses } from "../warehouses.mode";
import { ApiService } from "../api.service";
import { Router } from '@angular/router';

@Component({
  selector: 'app-warehouses',
  templateUrl: './warehouses.component.html',
  styleUrls: ['./warehouses.component.css']
})
export class WarehousesComponent implements AfterViewInit {

  constructor(private backend: ApiService,
    private router: Router ) { }


    title = 'Almacenes';
    resultsLength = 0;
    isLoadingResults = false;
    isRateLimitReached = false;
    data: Warehouses[] = [];
    displayedColumns: string[] = ['client', 'id', 'family', 'size', 'actions'];

    ngAfterViewInit() {
      this.backend.getWarehouses().subscribe(res => {
        this.data = res as Warehouses[];
        this.resultsLength = res.length;
      })
    }

  deleteItem(row: Warehouses) {
    this.router.navigate(['/warehouse', {id: row.id}]);
  }

  editItem(row: Warehouses) {
    this.router.navigate(['/warehouse', {id: row.id}]);
  }

  showDetails(row: Warehouses) {
    this.router.navigate(['/warehouse', {id: row.id}]);
  }

  addDetails() {
    this.router.navigate(['/warehouse'], { });
  }


}
