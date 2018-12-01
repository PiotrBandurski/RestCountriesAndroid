package piotr.bandurski.restcountries.data.api.retrofit

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import piotr.bandurski.restcountries.BuildConfig
import piotr.bandurski.restcountries.C
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

object RetrofitApiFactory {

    private const val TIMEOUT_IN_MILIS = 60 * 1000

    fun makeApiManager(callFactory: CallAdapter.Factory): RetrofitApiRequests {
        val retrofit = Retrofit.Builder()
            .baseUrl(C.Api.API_URL)
            .client(provideApiClient(TIMEOUT_IN_MILIS.toLong()))
            .addConverterFactory(provideApiConverter())
            .addCallAdapterFactory(callFactory)
            .build()

        return retrofit.create(RetrofitApiRequests::class.java)
    }

    fun provideApiClient(timeout: Long): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE

        val builder =  OkHttpClient().newBuilder()
            .connectTimeout(timeout, TimeUnit.MILLISECONDS)
            .readTimeout(timeout, TimeUnit.MILLISECONDS)
            .writeTimeout(timeout, TimeUnit.MILLISECONDS)
            .addInterceptor(loggingInterceptor)

        return builder.build()
    }

    fun provideApiConverter(): Converter.Factory {
        val gson = GsonBuilder().create()
        return GsonConverterFactory.create(gson)
    }
}