package piotr.bandurski.restcountries.data.api.retrofit

import io.reactivex.Single
import piotr.bandurski.restcountries.data.model.api.CountryApiModel
import retrofit2.http.GET

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

interface RetrofitApiRequests {

    @GET("all")
    fun getAllCountries(): Single<List<CountryApiModel>>
}