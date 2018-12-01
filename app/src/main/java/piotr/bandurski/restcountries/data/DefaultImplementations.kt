package piotr.bandurski.restcountries.data

import piotr.bandurski.restcountries.data.api.RestCountriesApi
import piotr.bandurski.restcountries.data.api.retrofit.RetrofitApiFactory
import piotr.bandurski.restcountries.data.api.retrofit.RetrofitRestCountriesApiImplementation
import piotr.bandurski.restcountries.data.database.RealmRestCountriesDatabaseImpl
import piotr.bandurski.restcountries.data.database.RestCountriesDatabase
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

class DefaultImplementations {

    companion object {
        fun provideDefaultApiImplementation(): RestCountriesApi{
            val factory = RxJava2CallAdapterFactory.create()
            val apiRequests = RetrofitApiFactory.makeApiManager(factory)
            return RetrofitRestCountriesApiImplementation(apiRequests)
        }

        fun provideDefaultDatabaseManagerImplementation(): RestCountriesDatabase = RealmRestCountriesDatabaseImpl
    }

}