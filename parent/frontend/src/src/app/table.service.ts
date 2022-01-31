import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {
  ActivatedRoute,
  ActivatedRouteSnapshot,
  Router,
  Params,
} from '@angular/router';
import { SearchRequest } from 'src/assets/intefaces/search.model';
import { SelectItem } from 'primeng';

@Injectable({
  providedIn: 'root',
})
export class TableService {
  params: SearchRequest;
  timeout = null;
  firstLoad = true;
  regions: SelectItem[] = [{ label: 'Select Region', value: null }];
  selectedRegion;
  rangeDates: Date[];

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private http: HttpClient
  ) {
    this.params = this.getPramas();
  }

  getSearchResulrts(url, params: Params) {
    return this.http.get<any>(url, {
      params,
    });
  }

  getAllCountryLanguages(countryId: number) {
    return this.http.get<any>(
      environment.getAllCountryLanguages + '/' + countryId
    );
  }

  getDistinctRegions() {
    return this.http.get<string[]>(environment.getDistinctRegions);
  }

  getPramas() {
    let newParams = this.route.snapshot.queryParams;

    if (newParams['filters']) {
      newParams = {
        ...newParams,
        filters: JSON.parse(atob(newParams['filters'])),
      };
    }

    if (newParams['sort']) {
      newParams = { ...newParams, sort: JSON.parse(atob(newParams['sort'])) };
    }
    return newParams;
  }

  getColumnSizes(tableName) {
    let table_state = JSON.parse(localStorage.getItem(tableName));
    if (tableName) {
      return table_state;
    }
  }

  reloadTableOnSameRouteRedirect() {
    this.router.routeReuseStrategy.shouldReuseRoute = function (
      future: ActivatedRouteSnapshot,
      curr: ActivatedRouteSnapshot
    ) {
      if (
        future.url.toString() === location.pathname.replace('/', '') &&
        curr.url.toString() === future.url.toString()
      ) {
        return false;
      }
      return future.routeConfig === curr.routeConfig;
    };
  }

  onFilter(value, col) {
    if (!value) {
      delete this.params.filters[col.field];
    } else if (col.type == 'date') {
      this.params = {
        ...this.params,
        filters: {
          ...this.params.filters,
          [col.start]: value[0].getFullYear(),
          [col.end]: value[1].getFullYear(),
        },
      };
    } else {
      this.params = {
        ...this.params,
        filters: {
          ...this.params.filters,
          [col.field]: value,
        },
      };
    }
    this.tableRedirect();
  }

  onPagenation(event) {
    console.log(event);
    this.params = { ...this.params, pageNum: event.first / event.rows };
    this.params = { ...this.params, pageSize: event.rows };
    this.tableRedirect();
  }

  onSorting(value) {
    if (!this.firstLoad) {
      if (!value[0]) {
        delete this.params.sort;
      } else {
        this.params = { ...this.params, sort: value[0] };
      }
      //Make a new timeout set to go off in 500ms (0.5 second)
      this.tableRedirect();
    }
  }

  handleSortColumn() {
    setTimeout(() => {
      this.firstLoad = true;
      if (this.params.sort) {
        let el = document.getElementById(this.params.sort.field);
        el.click();
        if (this.params.sort.order == -1) {
          el.click();
        }
      }
      this.firstLoad = false;
    });
  }

  onColumnResize(event, columns, tableName) {
    let column = columns.find((col) => {
      return col.header === event.element.outerText;
    });
    let table_state = JSON.parse(localStorage.getItem(tableName));
    if (tableName) {
      table_state = {
        ...table_state,
        [column.header]: { colWidth: event.element.clientWidth },
      };
    }
    localStorage.setItem(tableName, JSON.stringify(table_state));
  }

  getColWidth(header, columnSizes) {
    if (columnSizes && columnSizes[header]) {
      return columnSizes[header].colWidth + 'px';
    }
    return 'none';
  }

  encodedParams(): Params {
    let filters = { start: 'startYear', end: 'endYear', region: 'regionName' };
    if (
      this.params.filters &&
      (!this.params.filters['startYear'] || !this.params.filters['startYear'])
    ) {
      this.params = {
        ...this.params,
        filters: {
          ...this.params.filters,
          [filters.start]: null,
          [filters.end]: null,
        },
      };
    }

    if (this.params.filters && !this.params.filters['regionName']) {
      this.params = {
        ...this.params,
        filters: {
          ...this.params.filters,
          [filters.region]: null,
        },
      };
    }

    let newEcnsodedParmas = this.params as Params;

    if (
      newEcnsodedParmas.filters &&
      Object.keys(newEcnsodedParmas.filters).length
    ) {
      newEcnsodedParmas = {
        ...newEcnsodedParmas,
        filters: btoa(JSON.stringify(newEcnsodedParmas.filters)),
      };
    } else {
      delete newEcnsodedParmas.filters;
    }

    if (newEcnsodedParmas.sort && Object.keys(newEcnsodedParmas.sort).length) {
      newEcnsodedParmas = {
        ...newEcnsodedParmas,
        sort: btoa(JSON.stringify(newEcnsodedParmas.sort)),
      };
    } else {
      delete newEcnsodedParmas.sort;
    }

    return newEcnsodedParmas;
  }

  tableRedirect() {
    // this line is needed in order to reload the table component
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() =>
      this.router.navigate([location.pathname], {
        queryParams: this.encodedParams(),
      })
    );
  }
}
