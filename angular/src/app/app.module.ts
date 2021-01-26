import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EsgHeaderComponent } from './esg-header/esg-header.component';
import { UserInfoComponent } from './user-info/user-info.component';
import { GriGeneraldisclosuresComponent } from './gri-generaldisclosures/gri-generaldisclosures.component';
import { GriManagementapproachComponent } from './gri-managementapproach/gri-managementapproach.component';
import { GriEconomicComponent } from './gri-economic/gri-economic.component';
import { FormsModule } from '@angular/forms';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { GriEnvironmentalComponent } from './gri-environmental/gri-environmental.component';
import { GriSocialComponent } from './gri-social/gri-social.component';


@NgModule({
  declarations: [
    AppComponent,
    EsgHeaderComponent,
    UserInfoComponent,
    GriGeneraldisclosuresComponent,
    GriManagementapproachComponent,
    GriEconomicComponent,
    GriEnvironmentalComponent,
    GriSocialComponent,
    PageNotFoundComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
