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
import { SelectItem, Table } from 'primeng';

@Component({
  templateUrl: './continents-countries.component.html',
  styleUrls: ['./continents-countries.component.scss'],
})
export class ContinentsCountriesComponent implements OnInit, AfterViewInit {
  @ViewChild('dt', { static: true }) table: Table;

  cols: any[];
  tableData: any[];
  total: number;
  link: string;
  position: number;
  pageSize = 10;
  loading = true;
  columnSizes: any;
  regions: SelectItem[] = [{ label: 'Select Region', value: null }];
  selectedRegion;
  rangeDates: Date[];

  constructor(
    public activatedroute: ActivatedRoute,
    public tableService: TableService,
    private cdr: ChangeDetectorRef
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
      { field: 'countryName', header: 'Country Name', sortable: true },
      {
        field: 'regionName',
        header: 'Region Name',
        searchable: true,
        type: 'dd',
        sortable: true,
      },
      { field: 'continentName', header: 'Continent Name', sortable: true },
      {
        field: 'year',
        header: 'Year',
        sortable: true,
        searchable: true,
        type: 'date',
        start: 'startYear',
        end: 'endYear',
      },
      { field: 'population', header: 'Population', sortable: true },
      { field: 'gdp', header: 'GDP', sortable: true },
    ];
    this.columnSizes = this.tableService.getColumnSizes(
      'continents-countries-table'
    );
    this.loadTableData(this.tableService.encodedParams());
  }

  loadTableData(params) {
    this.loading = true;
    this.tableService.getDistinctRegions().subscribe((regionData) => {
      regionData.forEach((region) =>
        this.regions.push({ value: region, label: region })
      );
      this.tableService
        .getSearchResulrts(environment.getContinentsCountriesView, params)
        .subscribe((data) => {
          this.tableData = data.content;
          this.total = data.totalElements;
          this.loading = false;
        });
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
      if (
        this.tableService.params.filters &&
        this.tableService.params?.filters['startYear'] &&
        this.tableService.params?.filters['endYear']
      ) {
        this.rangeDates = [
          new Date(this.tableService.params?.filters['startYear'], 0),
          new Date(this.tableService.params?.filters['endYear'], 0),
        ];
      }
      if (
        this.tableService.params.filters &&
        this.tableService.params?.filters['regionName']
      ) {
        this.selectedRegion = this.tableService.params?.filters['regionName'];
      }
    });
    //Needed for expression changed after it has been checked error
    this.cdr.detectChanges();
  }
}
