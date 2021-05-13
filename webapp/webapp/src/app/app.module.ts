import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
// used to create fake backend
import { fakeBackendProvider } from './_helpers';

import { AppRoutingModule } from './app-routing.module';
import { JwtInterceptor, ErrorInterceptor } from './_helpers';
import { AppComponent } from './app.component';
import { AlertComponent } from './_components/alert.component';
import { HomeComponent } from './home';;
import { HeaderComponent } from './ui/header/header.component' ;
import { FooterComponent } from './ui/footer/footer.component';
import { LayoutComponent } from './ui/layout/layout.component';

import { routes } from './router-config';
//import { InMemoryWebApiModule } from 'angular-in-memory-web-api';

import { RouterModule } from '@angular/router';;
//import { EmployeeComponent } from './employee/employee.component';
import { ContactComponent } from './contact/contact.component';
@NgModule({
    imports: [
        BrowserModule,
        ReactiveFormsModule,
        HttpClientModule,
        AppRoutingModule,
        FormsModule,
        BrowserModule,
        ReactiveFormsModule,
        FormsModule,

        HttpClientModule,
        RouterModule.forRoot(routes),
        //InMemoryWebApiModule.forRoot(EmployeeData),
    ],
    declarations: [
        AppComponent,
        AlertComponent,
        HomeComponent,
        HeaderComponent,
        FooterComponent,
        LayoutComponent
,
       // EmployeeComponent ,
        ContactComponent   ],
    providers: [
        { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
        { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },

        // provider used to create fake backend
        fakeBackendProvider
    ],
    bootstrap: [AppComponent]
})
export class AppModule { };