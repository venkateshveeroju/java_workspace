import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { GriGeneraldisclosuresComponent } from './gri-generaldisclosures/gri-generaldisclosures.component';
import { GriManagementapproachComponent } from './gri-managementapproach/gri-managementapproach.component';
import { GriEconomicComponent } from './gri-economic/gri-economic.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { GriEnvironmentalComponent } from './gri-environmental/gri-environmental.component';
import { GriSocialComponent } from './gri-social/gri-social.component';

const routes: Routes = [

  { path: "", component: GriGeneraldisclosuresComponent },
  { path: "managementapproach", component: GriManagementapproachComponent },
  { path: "economic", component: GriEconomicComponent },
  { path: "environmental", component: GriEnvironmentalComponent },
  { path: "social", component: GriSocialComponent },
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
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
