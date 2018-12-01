package piotr.bandurski.restcountries.dependencyinjection

import android.content.Context
import piotr.bandurski.restcountries.base.BaseActivity
import toothpick.config.Module

class RestCountriesActivityModule(activity: BaseActivity): Module() {
    init {
        bind(Context::class.java).toInstance(activity)
        bind(BaseActivity::class.java).toInstance(activity)
    }

}