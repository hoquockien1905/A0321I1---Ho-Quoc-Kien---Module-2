import {Component, OnInit} from '@angular/core';
import {EmployeeService} from '../employee.service';
import {Employee} from '../model/employee';
import {Division} from '../model/division';
import {FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.scss']
})
export class EmployeeListComponent implements OnInit {

  public employeeList: Employee[];
  public divisionList: Division[];
  public formGroup: FormGroup;

  constructor(private employeeService: EmployeeService,
              private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.getAllEmployee();
    this.getAllDivision();
    this.myForm();
  }

  public getAllDivision(): void {
    this.employeeService.getAllDivision().subscribe(
      data => {
        this.divisionList = data;
      });
  }

  public getAllEmployee(): void {
    this.employeeService.getAllEmployee().subscribe(
      data => {
        this.employeeList = data;
      }
    );
  }

  public myForm() {
    this.formGroup = this.formBuilder.group({
      id: [''],
      name: [''],
      email: [''],
      phone: [''],
      division: [''],
    });
  }

  public onOpenModal(employee: Employee, mode: string): void {
    const container = document.getElementById('main-content');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addEmployeeModal');
    }
    if (mode === 'edit') {
      button.setAttribute('data-target', '#updateEmployeeModal');
    }
    if (mode === 'delete') {
      button.setAttribute('data-target', '#deleteEmployeeModal');
    }

    container.appendChild(button);
    button.click();
    console.log(employee, mode);
  }
}
