import { NgModule } from '@angular/core';
import { ComponentsSidebarComponent } from './components-sidebar/components-sidebar.component';
import { UtilitiesSidebarComponent } from './utilities-sidebar/utilities-sidebar.component';
import { RouterModule, Routes } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
const routes: Routes = [
  { path: 'Utilities-sidebar', component: UtilitiesSidebarComponent },
  { path: 'footer', component: FooterComponent },
  { path: 'header', component: HeaderComponent }
]
  



@NgModule({
  imports: [
    RouterModule
  ],
  declarations: [
    ComponentsSidebarComponent,
    UtilitiesSidebarComponent
  ],
  exports: [
    ComponentsSidebarComponent,
    UtilitiesSidebarComponent
  ]
})

export class SharedModule { }