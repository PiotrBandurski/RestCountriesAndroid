package piotr.bandurski.restcountries.presentation.list.adapter.viewmodel

import com.brandongogetap.stickyheaders.exposed.StickyHeader

/**
 * Created by Piotr Bandurski  on 02/12/2018.
 */

class HeaderViewModel(label: String)
    : AbstractCountryListViewModel(headerLabel = label, viewType = HEADER), StickyHeader