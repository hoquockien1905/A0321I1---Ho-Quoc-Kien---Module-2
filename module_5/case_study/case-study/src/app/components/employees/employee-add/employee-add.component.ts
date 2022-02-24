import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {EmployeeService} from "../../../services/employee.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-employee-add',
  templateUrl: './employee-add.component.html',
  styleUrls: ['./employee-add.component.scss']
})
export class EmployeeAddComponent implements OnInit {

  public formGroup: FormGroup;

  constructor(
    public employeeService: EmployeeService,
    public formBuilder: FormBuilder,
    public route: Router
  ) { }

  ngOnInit(): void {
    this.formGroup = this.formBuilder.group({
      name: ['', Validators.required],
      email: ['', Validators.required, Validators.email],
      dob: ['', Validators.required],
      phone: ['', Validators.required, Validators.pattern('^[0-9]{9}$')],
      address: ['', Validators.required],
      degree: ['', Validators.required],
      division: ['', Validators.required]
    });
  }

  get email() { return this.formGroup.get('email'); }

  onSubmit() {
    console.log(this.formGroup.value);
    this.employeeService.addNewEmployee(this.formGroup.value).subscribe(
      data => {
        this.route.navigateByUrl('employee-list');
      }
    );
  }
}
