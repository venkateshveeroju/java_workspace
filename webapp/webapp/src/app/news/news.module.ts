import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CurrentTopicsComponent } from './current-topics/current-topics.component';
import { CareerComponent } from './career/career.component';
import { RouterModule, Routes } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AdminComponent } from '../admin/admin.component';

const routes: Routes = [
  { path: 'career', component: CareerComponent },
  { path: 'current-topics', component: CurrentTopicsComponent }
]

@NgModule({
  declarations: [AdminComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    NgbModule
  ]
})
export class NewsModule { }
