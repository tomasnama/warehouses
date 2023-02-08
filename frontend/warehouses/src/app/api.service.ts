import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Warehouses } from "./warehouses.mode";
import { Racks } from "./racks.mode";
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private _httpClient: HttpClient) {}

  headers = new HttpHeaders({'Content-Type':'application/json; charset=utf-8'});

  getWarehouses(): Observable<Warehouses[]> {
    const href = 'http://localhost:8080/warehouses';
    const requestUrl = href;
    return this._httpClient.get<Warehouses[]>(requestUrl);
  }

  getWarehouse(id: any): Observable<Warehouses> {
    const href = 'http://localhost:8080/warehouses/';
    const requestUrl = href+id;
    return this._httpClient.get<Warehouses>(requestUrl);
  }

  putWarehouse(row: any): Observable<Warehouses> {
    const href = 'http://localhost:8080/warehouses/';
    const requestUrl = href+row.id;
    return this._httpClient.put<Warehouses>(requestUrl, row, { headers: this.headers});
  }

  postWarehouse(row: any): Observable<Warehouses> {
    const href = 'http://localhost:8080/warehouses';
    const requestUrl = href;
    return this._httpClient.post<Warehouses>(requestUrl,row, { headers: this.headers});
  }

  deleteWarehouse(id: number): Observable<boolean> {
    const href = 'http://localhost:8080/warehouses/';
    const requestUrl = href+id;
    return this._httpClient.delete<boolean>(requestUrl);
  }

  getRacks(id: any): Observable<Racks[]> {
    const href = 'http://localhost:8080/racks/';
    const requestUrl = href+id;
    return this._httpClient.get<Racks[]>(requestUrl);
  }

  postRacks(row: any): Observable<Racks> {
    const href = 'http://localhost:8080/racks';
    const requestUrl = href;
    return this._httpClient.post<Racks>(requestUrl,row, { headers: this.headers});
  }

  deleteRacks(id: number): Observable<boolean> {
    const href = 'http://localhost:8080/racks/';
    const requestUrl = href+id;
    return this._httpClient.delete<boolean>(requestUrl);
  }


}
