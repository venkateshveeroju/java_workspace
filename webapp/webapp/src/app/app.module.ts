import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './shared/header/header.component';
import { FooterComponent } from './shared/footer/footer.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ChartsModule } from 'ng2-charts';
import { HomeComponent } from './home/home.component';
import { GalleryComponent } from './gallery/gallery.component';
import { ContactComponent } from './contact/contact.component';
import { NgxGalleryModule } from 'ngx-gallery-9';
import { PublicationsComponent } from './publications/publications.component';
import { TranscriptionfactorComponent } from './transcriptionfactor/transcriptionfactor.component';
import { TechniquesComponent } from './techniques/techniques.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    DashboardComponent,
    HomeComponent,
    GalleryComponent,
    ContactComponent,
    PublicationsComponent,
    TranscriptionfactorComponent,
    TechniquesComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    NgbModule,
    ChartsModule,
    NgxGalleryModule
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule { }
