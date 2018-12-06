package piotr.bandurski.restcountries.presentation.list

import android.os.Bundle
import piotr.bandurski.restcountries.base.BaseActivity

class CountriesListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            openFragment(CountriesListFragment::class.java)
        }
    }

}
