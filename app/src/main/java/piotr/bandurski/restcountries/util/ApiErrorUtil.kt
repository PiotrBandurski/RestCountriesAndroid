package piotr.bandurski.restcountries.util

import android.app.Application
import piotr.bandurski.restcountries.R
import piotr.bandurski.restcountries.RestCountriesApplication
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

@Singleton
class ApiErrorUtil @Inject constructor(private val context: RestCountriesApplication) {

    fun getSuitableErrorMessage(e: Throwable): String{
        if (e is UnknownHostException || e is SocketTimeoutException) {
            return context.getString(R.string.error_cannot_connect_to_server)
        } //we can make here some other errors parsing etc...
        return context.getString(R.string.some_error)
    }
}