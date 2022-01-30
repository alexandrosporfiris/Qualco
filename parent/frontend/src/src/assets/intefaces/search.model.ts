export interface SearchRequest {
  pageNum?: number;
  pageSize?: number;
  filters?: SearchFilter[];
  sort?: SearchSort;

}

export interface SearchFilter {
  [key: string]: any;
}

export interface SearchSort {
  field: string;
  order: 1 | -1;
}
