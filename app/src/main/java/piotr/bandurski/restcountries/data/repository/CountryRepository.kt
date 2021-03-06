package piotr.bandurski.restcountries.data.repository

import piotr.bandurski.restcountries.data.api.RestCountriesApi
import piotr.bandurski.restcountries.data.database.RestCountriesDatabase
import piotr.bandurski.restcountries.data.mapper.CountryMapper
import piotr.bandurski.restcountries.data.model.database.Country
import piotr.bandurski.restcountries.dependencyinjection.annotations.ActivitySingleton
import javax.inject.Inject

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */
@ActivitySingleton
class CountryRepository @Inject constructor(private val countryMapper: CountryMapper,
                                            private val restCountriesApi: RestCountriesApi,
                                            private val restCountriesDatabase: RestCountriesDatabase) {

    fun getAllCountriesFromApi() = restCountriesApi.getAllCountries().map { countryMapper.mapCountries(it) }

    fun saveAllCountriesToDatabase(countries: List<Country>) = restCountriesDatabase.saveCountries(countries)

    fun getAllCountriesFromDatabase() = restCountriesDatabase.getAllCountries()
}