import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { GriGeneraldisclosuresComponent } from './gri-generaldisclosures/gri-generaldisclosures.component';
import { GriManagementapproachComponent } from './gri-managementapproach/gri-managementapproach.component';
import { GriEconomicComponent } from './gri-economic/gri-economic.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { GriEnvironmentalComponent } from './gri-environmental/gri-environmental.component';
import { GriSocialComponent } from './gri-social/gri-social.component';
//import { EsgHeaderComponent } from './esg-header/esg-header.component';
// uncommented below 1 line
import { LoginComponent } from './login/login.component';
const routes: Routes = [

  { path: "gri102", component: GriGeneraldisclosuresComponent },
  { path: "gri103", component: GriManagementapproachComponent },
  { path: "gri200", component: GriEconomicComponent },
  { path: "gri300", component: GriEnvironmentalComponent },
  { path: "gri400", component: GriSocialComponent },


  //{ path: "", redirectTo: 'gri102', pathMatch: 'full' },
// uncommented below 2 lines 
  { path: 'login', component: LoginComponent },
  { path: "", redirectTo: 'login', pathMatch: 'full' },

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