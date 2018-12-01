package piotr.bandurski.restcountries.util

import android.content.Context
import piotr.bandurski.restcountries.R
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

class ApiErrorUtil @Inject constructor(private val context: Context) {

    fun getSuitableErrorMessage(e: Throwable): String{
        if (e is UnknownHostException || e is SocketTimeoutException) {
            return context.getString(R.string.error_cannot_connect_to_server)
        } //we can make here some other errors parsing etc...
        return context.getString(R.string.some_error)
    }
}