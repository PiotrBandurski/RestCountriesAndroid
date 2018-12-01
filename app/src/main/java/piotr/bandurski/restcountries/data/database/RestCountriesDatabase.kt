package piotr.bandurski.restcountries.data.database

import piotr.bandurski.restcountries.data.model.database.Country

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

interface RestCountriesDatabase {

    fun getAllCountries(): List<Country>

    fun saveCountries(countries: List<Country>)
}