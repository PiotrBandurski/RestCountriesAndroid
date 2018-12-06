package piotr.bandurski.restcountries.data.api

import io.reactivex.Single
import piotr.bandurski.restcountries.data.model.api.CountryApiModel

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

interface RestCountriesApi {

    fun getAllCountries(): Single<List<CountryApiModel>>

    fun queryCountriesByName(query: String?): Single<List<CountryApiModel>>

}