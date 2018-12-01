package piotr.bandurski.restcountries

import android.app.Application
import io.realm.Realm
import piotr.bandurski.restcountries.dependencyinjection.DependencyUtil

class RestCountriesApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)

        DependencyUtil.createAppScopeAndInject(this)
    }
}