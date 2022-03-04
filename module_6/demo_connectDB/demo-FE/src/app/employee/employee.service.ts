import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Employee} from './model/employee';
import {environment} from '../../environments/environment';
import {Division} from './model/division';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private httpClient: HttpClient) { }

  public getAllDivision(): Observable<Division[]> {
    return this.httpClient.get<Division[]>(`${this.apiServerUrl}/employee/list-division`);
  }

  public getAllEmployee(): Observable<Employee[]> {
    return this.httpClient.get<Employee[]>(`${this.apiServerUrl}/employee/list`);
  }

  public addEmployee(employee: Employee): Observable<Employee> {
    return this.httpClient.post<Employee>(`${this.apiServerUrl}/employee/add`, employee);
  }

  public updateEmployee(employee: Employee): Observable<Employee> {
    return this.httpClient.put<Employee>(`${this.apiServerUrl}/employee/update`, employee);
  }

  public deleteEmployee(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.apiServerUrl}/employee/delete/${id}`);
  }
}
