import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


import { LabManagementComponent } from './lab-management/lab-management.component';
import { ResearchComponent } from './research/research.component';
import { EmpComponent } from './emp/emp.component';

const routes: Routes = [
  { path: 'lab-management', component: LabManagementComponent },
  { path: 'research', component: ResearchComponent },
  { path: 'emp', component: EmpComponent }
]

@NgModule({
  declarations: [
    LabManagementComponent,EmpComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    NgbModule
  ]
})
export class EmployeesModule { }