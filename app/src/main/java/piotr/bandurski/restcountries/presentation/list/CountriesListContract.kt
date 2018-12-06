package piotr.bandurski.restcountries.presentation.list

import piotr.bandurski.restcountries.base.MvpPresenter
import piotr.bandurski.restcountries.base.MvpView
import piotr.bandurski.restcountries.data.model.database.Country
import piotr.bandurski.restcountries.presentation.list.adapter.viewmodel.AbstractCountryListViewModel

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

interface CountriesListContract {

    interface View: MvpView {
        fun getViewModel(): CountriesListViewModel
        fun bindCountriesToView(countiesListViewModels: List<AbstractCountryListViewModel>)
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter: MvpPresenter<View>{
        fun loadCountries()
    }
}