package piotr.bandurski.restcountries.data.api.retrofit

import io.reactivex.Single
import piotr.bandurski.restcountries.data.api.RestCountriesApi
import piotr.bandurski.restcountries.data.model.api.CountryApiModel
import javax.inject.Inject

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

class RetrofitRestCountriesApiImplementation @Inject constructor(private val retrofitApiRequests: RetrofitApiRequests): RestCountriesApi{

    override fun getAllCountries() = retrofitApiRequests.getAllCountries()

}