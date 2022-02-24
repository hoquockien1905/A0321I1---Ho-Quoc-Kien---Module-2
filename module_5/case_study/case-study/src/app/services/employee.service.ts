import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  public API:string = "http://localhost:3000/employees";

  constructor(public httpClient:HttpClient) {
  }

  getAllEmployees(): Observable<any> {
    return this.httpClient.get<any>(this.API);
  }

  addNewEmployee(employee): Observable<any> {
    return this.httpClient.post(this.API, employee);
  }
}
