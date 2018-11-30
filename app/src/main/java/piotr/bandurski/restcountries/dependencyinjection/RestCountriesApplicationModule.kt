package piotr.bandurski.restcountries.dependencyinjection

import android.app.Application
import toothpick.config.Module


class RestCountriesApplicationModule(private val application: Application): Module() {
}