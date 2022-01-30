import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent implements OnInit {
  items: MenuItem[];

  activeItem: MenuItem;

  ngOnInit() {
    this.items = [
      { label: 'Home', icon: 'pi pi-fw pi-home', url: '/home' },
      { label: 'Countries (Task 1)', icon: 'pi pi-fw pi-list' , url:'/countries' },
      { label: 'GDP (Task 2)', icon: 'pi pi-fw pi-money-bill', url:'/countries-gdp' },
      {
        label: 'Continents - Countries (Task 3)',
        icon: 'pi pi-fw pi-globe',
        url: '/continents-countries',
      }
    ];

    this.activeItem = this.items.find((item) => item.url == location.pathname)
      ? this.items.find((item) => item.url == location.pathname)
      : this.items[0];
  }
}
