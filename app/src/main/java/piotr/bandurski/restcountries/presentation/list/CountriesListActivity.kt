package piotr.bandurski.restcountries.presentation.list

import android.os.Bundle
import piotr.bandurski.restcountries.base.AbstractSearchableActivity
import javax.inject.Inject

class CountriesListActivity : AbstractSearchableActivity() {

    @Inject
    lateinit var countriesListFragment: CountriesListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        openFragment(countriesListFragment)
    }

}
