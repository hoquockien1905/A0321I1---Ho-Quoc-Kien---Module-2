import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {PageNotFoundComponent} from "./components/page-not-found/page-not-found.component";
import {EmployeeListComponent} from "./components/employees/employee-list/employee-list.component";
import {CustomerListComponent} from "./components/customers/customer-list/customer-list.component";
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NgxPaginationModule} from 'ngx-pagination';
import { EmployeeAddComponent } from './components/employees/employee-add/employee-add.component';
import {CommonModule} from '@angular/common';

const routes: Routes = [
  {path: "", component: HomeComponent},
  {path: "home", component: HomeComponent},
  {path: "employee-list", component: EmployeeListComponent},
  {path: "customer-list", component: CustomerListComponent},
  {path: "employee-add", component: EmployeeAddComponent},

  {path: "**", component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes),
    Ng2SearchPipeModule,
    FormsModule,
    NgxPaginationModule, ReactiveFormsModule, CommonModule
  ],
  exports: [RouterModule],
  declarations: [EmployeeAddComponent]
})
export class AppRoutingModule {
}
