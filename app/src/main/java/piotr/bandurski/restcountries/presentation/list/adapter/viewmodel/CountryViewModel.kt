package piotr.bandurski.restcountries.presentation.list.adapter.viewmodel

import piotr.bandurski.restcountries.data.model.database.Country

/**
 * Created by Piotr Bandurski  on 02/12/2018.
 */

class CountryViewModel(country: Country): AbstractCountryListViewModel(viewType = COUNTRY_CELL, country = country)