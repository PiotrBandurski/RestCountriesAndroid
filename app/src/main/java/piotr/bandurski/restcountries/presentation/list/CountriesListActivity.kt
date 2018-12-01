package piotr.bandurski.restcountries.presentation.list

import android.os.Bundle
import piotr.bandurski.restcountries.base.BaseActivity
import javax.inject.Inject

class CountriesListActivity : BaseActivity() {

    @Inject
    lateinit var countriesListFragment: CountriesListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        openFragment(countriesListFragment)
    }

}
