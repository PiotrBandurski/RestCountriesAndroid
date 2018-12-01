package piotr.bandurski.restcountries.data.database

import piotr.bandurski.restcountries.data.model.database.Country

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

object RealmRestCountriesDatabaseImpl: RealmDatabaseHelper(), RestCountriesDatabase {

    override fun getAllCountries(): List<Country> = findAll(Country::class.java)

    override fun saveCountries(countries: List<Country>) = saveObjects(countries)
}