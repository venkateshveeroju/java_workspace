import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';

import { LoginComponent } from './login/login.component';

import { EsgHeaderComponent } from './esg-header/esg-header.component';
import { UserInfoComponent } from './user-info/user-info.component';
import { GriGeneraldisclosuresComponent } from './gri-generaldisclosures/gri-generaldisclosures.component';
import { GriManagementapproachComponent } from './gri-managementapproach/gri-managementapproach.component';
import { GriEconomicComponent } from './gri-economic/gri-economic.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { GriEnvironmentalComponent } from './gri-environmental/gri-environmental.component';
import { GriSocialComponent } from './gri-social/gri-social.component';

import { authInterceptorProviders } from './_helpers/auth.interceptor';



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
    LoginComponent,
    
   
    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
