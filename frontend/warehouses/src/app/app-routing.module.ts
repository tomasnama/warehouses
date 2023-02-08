import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { WarehouseComponent } from './warehouse/warehouse.component';
import { WarehousesComponent } from './warehouses/warehouses.component';

const routes: Routes = [
  { path: 'home', component: WarehousesComponent },
  { path: 'warehouse', component: WarehouseComponent },
  { path: '', component: WarehousesComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
