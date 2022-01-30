import { environment } from 'src/environments/environment';
import {
  Component,
  OnInit,
  ViewChild,
  ElementRef,
  AfterViewInit,
  ChangeDetectorRef,
} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TableService } from '../table.service';
import { Table } from 'primeng';

@Component({
  templateUrl: './countries.component.html',
  styleUrls: ['./countries.component.scss'],
})
export class CountriesComponent implements OnInit, AfterViewInit {
  @ViewChild('dt', { static: true }) table: Table;

  cols: any[];
  tableData: any[];
  total: number;
  link: string;
  position: number;
  pageSize = 10;
  loading = true;
  columnSizes: any;
  languages: any;
  selectedCountryName: string;
  displayDialog = false;

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
      { field: 'name', header: 'Country Name', type: 'string', sortable: true },
      { field: 'area', header: 'Area', type: 'string', sortable: true },
      {
        field: 'countryCode2',
        header: 'Country Code (2 Letters)',
        type: 'string',
        sortable: true,
      },
    ];
    this.columnSizes = this.tableService.getColumnSizes('countries-table');
    this.loadTableData(this.tableService.encodedParams());
  }

  loadTableData(params) {
    this.loading = true;
    this.tableService
      .getSearchResulrts(environment.getAllCountriesView, params)
      .subscribe((data) => {
        this.tableData = data.content;
        this.total = data.totalElements;
        this.loading = false;
      });
  }

  onRowSelect(event) {
    this.selectedCountryName = event.data.name;
    this.tableService
      .getAllCountryLanguages(event.data.id)
      .subscribe((data) => {
        this.languages = data;
        this.displayDialog = true;
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
