package piotr.bandurski.restcountries.dependencyinjection

import android.app.Application
import android.content.Context
import piotr.bandurski.restcountries.data.DefaultImplementations
import piotr.bandurski.restcountries.data.api.RestCountriesApi
import piotr.bandurski.restcountries.data.database.RestCountriesDatabase
import piotr.bandurski.restcountries.presentation.list.CountriesListContract
import piotr.bandurski.restcountries.presentation.list.CountriesListPresenter
import toothpick.config.Module


class RestCountriesApplicationModule(application: Application): Module() {
    init {
        bind(Context::class.java).toInstance(application)
        bind(Application::class.java).toInstance(application)
        bind(RestCountriesApi::class.java).toProviderInstance{ DefaultImplementations.provideDefaultApiImplementation() }
        bind(RestCountriesDatabase::class.java).toProviderInstance{ DefaultImplementations.provideDefaultDatabaseManagerImplementation() }


        bindPresenters()
    }

    private fun bindPresenters(){
        bind(CountriesListContract.Presenter::class.java).to(CountriesListPresenter::class.java)
    }
}