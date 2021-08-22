import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomeComponent } from './home/home.component';
import { GalleryComponent } from './gallery/gallery.component';
import { ContactComponent } from './contact/contact.component';
import { SigninComponent } from './general-pages/signin/signin.component';
import { SignupComponent } from './general-pages/signup/signup.component';
import { PublicationsComponent } from './publications/publications.component';
import { TranscriptionfactorComponent } from './transcriptionfactor/transcriptionfactor.component';
import { TechniquesComponent } from './techniques/techniques.component';


const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'gallery', component: GalleryComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'signin', component: SigninComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'employees', loadChildren: () => import('./employees/employees.module').then(m => m.EmployeesModule) },
  { path: 'publications', component: PublicationsComponent },
  { path: 'transcriptionfactor', component: TranscriptionfactorComponent },
  { path: 'techniques', component: TechniquesComponent },
  { path: 'ui-elements', loadChildren: () => import('./ui-elements/ui-elements.module').then(m => m.UiElementsModule) },
  { path: 'form', loadChildren: () => import('./form/form.module').then(m => m.FormModule) },
  { path: 'charts', loadChildren: () => import('./charts/charts.module').then(m => m.ChartsDemoModule) },
  { path: 'tables', loadChildren: () => import('./tables/tables.module').then(m => m.TablesModule) },
  { path: '**', redirectTo: 'general-pages/page-404' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
