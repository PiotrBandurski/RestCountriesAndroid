package piotr.bandurski.restcountries.presentation.list

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import com.brandongogetap.stickyheaders.StickyLayoutManager
import kotlinx.android.synthetic.main.countries_list_fragment_layout.*
import piotr.bandurski.restcountries.R
import piotr.bandurski.restcountries.base.BaseMVPViewFragment
import piotr.bandurski.restcountries.base.MvpPresenter
import piotr.bandurski.restcountries.base.SearchableActivity
import piotr.bandurski.restcountries.data.model.database.Country
import piotr.bandurski.restcountries.presentation.list.adapter.CountriesListAdapter
import piotr.bandurski.restcountries.presentation.list.adapter.CountriesListFactory
import javax.inject.Inject

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

class CountriesListFragment @Inject constructor()
    : BaseMVPViewFragment(R.layout.countries_list_fragment_layout),
    CountriesListContract.View,
    SearchView.OnQueryTextListener{

    @Inject
    lateinit var presenter: CountriesListContract.Presenter

    @Inject
    lateinit var countriesListAdapter: CountriesListAdapter

    @Inject
    lateinit var countriesListFactory: CountriesListFactory

    override fun getPresenter(): MvpPresenter<Nothing> = presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        presenter.loadCountries()
        (activity as? SearchableActivity)?.run {
            setSearchBarVisibility(true)
            setOnQueryTextChangeListener(this@CountriesListFragment)
        }
    }

    override fun bindCountriesToView(countries: List<Country>) {
        countriesListAdapter.submitList(countriesListFactory.create(countries))
    }

    override fun showLoading() = getBaseActivity().showToolbarProgress()

    override fun hideLoading() = getBaseActivity().hideToolbarProgress()

    override fun showNoCountriesFoundInfo() {
        noResultsTextView.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
    }

    override fun hideNoCountriesFoundInfo() {
        noResultsTextView.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        presenter.queryCountries(query)
        return true
    }

    override fun onQueryTextChange(newText: String?) = onQueryTextSubmit(newText)

    private fun setupRecyclerView(){
        recyclerView.apply {
            layoutManager = StickyLayoutManager(requireContext(), countriesListAdapter)
            adapter = countriesListAdapter
        }
    }
}