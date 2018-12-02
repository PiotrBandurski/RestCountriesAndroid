package piotr.bandurski.restcountries.presentation.list.adapter.viewmodel

import piotr.bandurski.restcountries.data.model.database.Country

/**
 * Created by Piotr Bandurski  on 02/12/2018.
 */

abstract class AbstractCountryListViewModel(val viewType: Int,
                                            val country: Country? = null,
                                            val headerLabel: String? = null) {
    companion object {
        const val HEADER = 1
        const val COUNTRY_CELL = 2
    }
}