package piotr.bandurski.restcountries.presentation.list

import androidx.lifecycle.ViewModel
import piotr.bandurski.restcountries.presentation.list.adapter.viewmodel.AbstractCountryListViewModel

/**
 * Created by Piotr Bandurski on 06/12/2018.
 */

class CountriesListViewModel: ViewModel() {

    var countriesListViewModels: List<AbstractCountryListViewModel> = emptyList()

}