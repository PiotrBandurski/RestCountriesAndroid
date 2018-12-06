package piotr.bandurski.restcountries.base


import androidx.appcompat.widget.SearchView


interface SearchableActivity {
    fun setSearchBarVisibility(visibility: Boolean)
    fun setOnQueryTextChangeListener(onQueryTextChangeListener: SearchView.OnQueryTextListener?)
    fun setSearchHint(hint: String)
}
