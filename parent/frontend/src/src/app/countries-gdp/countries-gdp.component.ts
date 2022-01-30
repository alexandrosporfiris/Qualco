import {
  Component,
  OnInit,
  ViewChild,
  AfterViewInit,
  ChangeDetectorRef,
} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TableService } from '../table.service';
import { Table } from 'primeng';
import { environment } from 'src/environments/environment';

@Component({
  templateUrl: './countries-gdp.component.html',
  styleUrls: ['./countries-gdp.component.scss'],
})
export class CountriesGdpComponent implements OnInit, AfterViewInit {
  @ViewChild('dt', { static: true }) table: Table;

  cols: any[];
  tableData: any[];
  total: number;
  link: string;
  position: number;
  pageSize = 10;
  loading = true;
  columnSizes: any;

  constructor(
    public activatedroute: ActivatedRoute,
    public tableService: TableService,
    private cdr: ChangeDetectorRef,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.tableService.reloadTableOnSameRouteRedirect();
    this.tableInit();
  }

  // New Table methods Start
  tableInit() {
    // Specify Columns
    this.cols = [
      { header: '#', type: 'index' },
      { field: 'name', header: 'Country Name', sortable: true },
      {
        field: 'countryCode3',
        header: 'Country Code (3 Letters)',
        sortable: true,
      },
      {
        field: 'year',
        header: 'Max Ratio Year',
        sortable: true
      },
      { field: 'population', header: 'Population', sortable: true },
      { field: 'gdp', header: 'GDP', sortable: true },
      { field: 'ratio', header: 'Max Ratio', sortable: true },
    ];
    this.columnSizes = this.tableService.getColumnSizes('countries-gdp-table');
    this.loadTableData(this.tableService.encodedParams());
  }

  loadTableData(params) {
    this.loading = true;
    this.tableService
      .getSearchResulrts(environment.getCountriesGpdView, params)
      .subscribe((data) => {
        this.tableData = data.content;
        this.total = data.totalElements;
        this.loading = false;
      });
  }

  ngAfterViewInit() {
    //Needed to display sorting on view
    this.tableService.handleSortColumn();
    // Pagination position initialization
    setTimeout(() => {
      this.pageSize = this.tableService.params.pageSize
      ? this.tableService.params.pageSize
      : 10;
      this.position = this.tableService.params.pageNum
        ? this.tableService.params.pageNum * this.pageSize
        : 0;
    });
    //Needed for expression changed after it has been checked error
    this.cdr.detectChanges();
  }
}
