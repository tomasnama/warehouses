import {Component, Inject} from '@angular/core';
import {MatDialog, MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import { Racks } from '../racks.mode';


@Component({
  selector: 'app-dialog-rack',
  templateUrl: './dialog-rack.component.html',
  styleUrls: ['./dialog-rack.component.css']
})
export class DialogRackComponent {

  constructor(
    public dialogRef: MatDialogRef<DialogRackComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Racks,
  ) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

  idChanged(newValue: number) {
    this.data.id = newValue;
  }

  typeChanged(newValue: string) {
    this.data.type = newValue;
  }
    

}
