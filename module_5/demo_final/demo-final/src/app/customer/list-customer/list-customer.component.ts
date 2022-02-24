import { Component, OnInit } from '@angular/core';
import {CustomerService} from "../customer.service";
import {Customer} from "../model/customer";
import {FormBuilder, FormGroup} from "@angular/forms";
import {DeleteCustomerComponent} from "../delete-customer/delete-customer.component";
import {MatDialog} from "@angular/material/dialog";

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.scss']
})
export class ListCustomerComponent implements OnInit {

  customerList: Customer[];
  p = 1;
  formSearch: FormGroup;

  constructor(private customerService: CustomerService,
              private formBuilder: FormBuilder,
              private matDialog: MatDialog) {}


  ngOnInit(): void {
    this.createFormSearch();
    this.customerService.getAllCustomer().subscribe(data => {
      this.customerList = data;
      console.log(this.customerList);
    });
  }

  search() {
    this.customerService.searchCustomer(this.formSearch.value).subscribe(
      data => {
        this.p = 1;
        this.customerList = data;
      }
    );
  }

  createFormSearch() {
    this.formSearch = this.formBuilder.group({
      name: [''],
      email: [''],
      customerType: ['']
    });
  }

  openDialogDelete(id: number, name: string) {
    const dialogDelete = this.matDialog.open(DeleteCustomerComponent, {
      data: {id: id, name: name},
      height: '200px',
      width: '500px'
    });
    dialogDelete.afterClosed().subscribe(() => {
     this.getAllCustomer();
    });
  }

  private getAllCustomer() {
    this.customerService.getAllCustomer().subscribe(data => {
      this.customerList = data;
    });
  }
}
