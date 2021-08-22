import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


import { LabManagementComponent } from './lab-management/lab-management.component';

const routes: Routes = [
  { path: 'lab-management', component: LabManagementComponent }
]

@NgModule({
  declarations: [
    LabManagementComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    NgbModule
  ]
})
export class EmployeesModule { }