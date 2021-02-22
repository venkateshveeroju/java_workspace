import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { GriGeneraldisclosuresComponent } from './gri-generaldisclosures/gri-generaldisclosures.component';
import { GriManagementapproachComponent } from './gri-managementapproach/gri-managementapproach.component';
import { GriEconomicComponent } from './gri-economic/gri-economic.component';
import { GriEnvironmentalComponent } from './gri-environmental/gri-environmental.component';
import { GriSocialComponent } from './gri-social/gri-social.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

const routes: Routes = [
/*
  { path: "gri102", component: GriGeneraldisclosuresComponent },
  { path: "gri103", component: GriManagementapproachComponent },
  { path: "gri200", component: GriEconomicComponent },
  { path: "gri300", component: GriEnvironmentalComponent },
  { path: "gri400", component: GriSocialComponent },
  { path: "", redirectTo: 'gri102', pathMatch: 'full' },
*/
{ path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: "", redirectTo: 'home', pathMatch: 'full' },

  {
    path: 'page-not-found',
    component: PageNotFoundComponent
  },
  {
    path: "**",
    redirectTo: 'page-not-found'
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes, { enableTracing: false })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
