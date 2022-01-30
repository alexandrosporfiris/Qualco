import { CountriesGdpComponent } from './countries-gdp/countries-gdp.component';
import { ContinentsCountriesComponent } from './continents-countries/continents-countries.component';
import { HomeComponent } from './home/home.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CountriesComponent } from './countries/countries.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent, pathMatch: 'full' },
  {
    path: 'continents-countries',
    component: ContinentsCountriesComponent,
    pathMatch: 'full',
  },
  { path: 'countries', component: CountriesComponent, pathMatch: 'full' },
  { path: 'countries-gdp', component: CountriesGdpComponent, pathMatch: 'full' },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, {
      onSameUrlNavigation: 'reload', // enable Navigation in the Same Url
      initialNavigation: 'enabled',
    }),
  ],
  exports: [RouterModule],
})
export class AppRoutingModule {}
