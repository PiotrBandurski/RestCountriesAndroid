package piotr.bandurski.restcountries.presentation.list.adapter

import piotr.bandurski.restcountries.data.model.database.Country
import piotr.bandurski.restcountries.presentation.list.adapter.viewmodel.AbstractCountryListViewModel
import piotr.bandurski.restcountries.presentation.list.adapter.viewmodel.CountryViewModel
import piotr.bandurski.restcountries.presentation.list.adapter.viewmodel.HeaderViewModel
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Piotr Bandurski  on 02/12/2018.
 */
@Singleton
class CountriesListFactory @Inject constructor() {

    fun create(countries: List<Country>): List<AbstractCountryListViewModel> {
        val countries = countries.sortedBy { it.name }
        var lastFirstLetter: Char? = null
        var listToReturn = emptyList<AbstractCountryListViewModel>()

        for (country in countries) {
            if (lastFirstLetter != country.name?.first()) {
                lastFirstLetter = country.name?.first()
                listToReturn += HeaderViewModel(lastFirstLetter.toString())
            }
            listToReturn += CountryViewModel(country)
        }

        return listToReturn
    }
}