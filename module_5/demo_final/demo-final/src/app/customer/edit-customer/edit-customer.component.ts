import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {CustomerService} from "../customer.service";
import {FormBuilder, FormGroup} from "@angular/forms";
import {Customer} from "../model/customer";
import {CustomerType} from "../model/customer-type";

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.scss']
})
export class EditCustomerComponent implements OnInit {

  formGroup: FormGroup;
  customer: Customer;
  listCustomerType: CustomerType[];

  constructor(
    private activeRouter: ActivatedRoute,
    private customerService: CustomerService,
    private formBuilder: FormBuilder,
    private route: Router
  ) {
  }

  ngOnInit(): void {
    this.createForm();
    this.getAllCustomerType();
    this.activeRouter.paramMap.subscribe(
      (paramMap: ParamMap) => {
        const id = paramMap.get('id');
        this.customerService.getCustomerById(id).subscribe(
          data => {
            this.customer = data;
            this.formGroup.setValue(this.customer);
          }
        );
      }
    );
  }

  createForm() {
    this.formGroup = this.formBuilder.group({
      id: [],
      name: [],
      dob: [],
      email: [],
      customerType: []
    });
  }

  getAllCustomerType() {
    this.customerService.getAllCustomerType().subscribe(
      data => {
        this.listCustomerType = data;
        console.log(data);
      }
    );
  }

  compareFn(c1: CustomerType, c2: CustomerType): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }

  onSubmit() {
    if (this.formGroup.valid) {
      this.customerService.updateCustomer(this.formGroup.value).subscribe(
        () => {
          this.route.navigateByUrl('/customer');
        }
      );
    }
  }
}
