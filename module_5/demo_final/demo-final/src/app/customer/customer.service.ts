import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private httpClient: HttpClient) {
  }

  urlCustomer = 'http://localhost:3000/customers';
  urlCustomerType = 'http://localhost:3000/customerTypes';

  getAllCustomer(): Observable<any> {
    return this.httpClient.get(this.urlCustomer);
  }

  getAllCustomerType(): Observable<any> {
    return this.httpClient.get(this.urlCustomerType);
  }

  getCustomerById(id: any): Observable<any> {
    return this.httpClient.get(this.urlCustomer + '/' + id);
  }

  updateCustomer(customer: any): Observable<any> {
    return this.httpClient.put(this.urlCustomer + '/' + customer.id, customer);
  }

  searchCustomer(customer: any): Observable<any> {
    return this.httpClient.get(this.urlCustomer + '?name_like=' + customer.name + '&email_like=' + customer.email
    + '&customerType.typeName_like=' + customer.customerType);
  }


  deleteCustomer(id: any) {
    return this.httpClient.delete(this.urlCustomer + '/' + id);

  }
}
