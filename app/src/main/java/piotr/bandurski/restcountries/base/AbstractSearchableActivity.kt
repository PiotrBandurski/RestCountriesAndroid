package piotr.bandurski.restcountries.base

import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.toolbar.*
import piotr.bandurski.restcountries.R

abstract class AbstractSearchableActivity(@LayoutRes private val layoutRes: Int = R.layout.base_activity_layout): BaseActivity(layoutRes), SearchableActivity {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        searchView.layoutParams = Toolbar.LayoutParams(Gravity.END)
    }

    override fun setSearchBarVisibility(visibility: Boolean) {
        val viewVisibility = if (visibility){
            View.VISIBLE
        } else {
            View.GONE
        }
        searchView.visibility = viewVisibility
    }

    override fun setOnQueryTextChangeListener(onQueryTextChangeListener: SearchView.OnQueryTextListener?)
            = searchView.setOnQueryTextListener(onQueryTextChangeListener)

    override fun setSearchHint(hint: String) {
        searchView.queryHint = hint
    }

}