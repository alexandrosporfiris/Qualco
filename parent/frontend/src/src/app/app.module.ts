import { CountriesComponent } from './countries/countries.component';
import { ToastModule } from 'primeng/toast';
import { MessageService } from 'primeng/api';
import { CommonModule, registerLocaleData } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DialogModule } from 'primeng/dialog';
import { PanelModule } from 'primeng/panel';
import { DropdownModule } from 'primeng/dropdown';
import { MultiSelectModule } from 'primeng/multiselect';
import { FormsModule } from '@angular/forms';

import { LOCALE_ID, NgModule } from '@angular/core';
import { DataViewModule } from 'primeng/dataview';
import { ButtonModule } from 'primeng/button';
import { GalleriaModule } from 'primeng/galleria';
import { DynamicDialogModule } from 'primeng/dynamicdialog';
import { ListboxModule } from 'primeng/listbox';
import { BreadcrumbModule } from 'primeng/breadcrumb';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import {
  BrowserModule,
  BrowserTransferStateModule,
} from '@angular/platform-browser';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { TableModule } from 'primeng/table';
import { TabMenuModule } from 'primeng';
import { ContinentsCountriesComponent } from './continents-countries/continents-countries.component';
import { CountriesGdpComponent } from './countries-gdp/countries-gdp.component';
import {CalendarModule} from 'primeng/calendar';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ContinentsCountriesComponent,
    CountriesComponent,
    CountriesGdpComponent,
  ],
  imports: [
    CalendarModule,
    TableModule,
    TabMenuModule,
    ToastModule,
    NgbModule,
    CommonModule,
    HttpClientModule,
    BreadcrumbModule,
    ListboxModule,
    DynamicDialogModule,
    GalleriaModule,
    FormsModule,
    ButtonModule,
    MultiSelectModule,
    DropdownModule,
    PanelModule,
    DialogModule,
    DataViewModule,
    HttpClientModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    BrowserModule.withServerTransition({ appId: 'app-root' }),
    BrowserTransferStateModule,
    NgbModule,
  ],
  providers: [MessageService],
  bootstrap: [AppComponent],
})
export class AppModule {}
