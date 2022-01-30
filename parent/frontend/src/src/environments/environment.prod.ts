const api = '/api';
const search = api + '/search';

export const environment = {
  production: true,

  // Search Endpoints
  getAllCountriesView: search + '/getAllCountriesView',
  getAllCountryLanguages: search + '/getAllCountryLanguages',
  getCountriesGpdView: search + '/getCountriesGpdView',
  getContinentsCountriesView: search + '/getContinentsCountriesView',
  getDistinctRegions: search + '/getDistinctRegions'

};
