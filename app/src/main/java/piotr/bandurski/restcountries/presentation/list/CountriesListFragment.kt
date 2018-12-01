package piotr.bandurski.restcountries.presentation.list

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.countries_list_fragment_layout.*
import piotr.bandurski.restcountries.R
import piotr.bandurski.restcountries.base.BaseMVPViewFragment
import piotr.bandurski.restcountries.base.MvpPresenter
import piotr.bandurski.restcountries.data.model.database.Country
import piotr.bandurski.restcountries.presentation.list.adapter.CountriesListAdapter
import javax.inject.Inject

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

class CountriesListFragment @Inject constructor(): BaseMVPViewFragment(R.layout.countries_list_fragment_layout), CountriesListContract.View {

    @Inject
    lateinit var presenter: CountriesListContract.Presenter

    @Inject
    lateinit var countriesListAdapter: CountriesListAdapter

    override fun getPresenter(): MvpPresenter<Nothing> = presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        presenter.loadCountries()
    }

    override fun bindCountriesToView(countries: List<Country>) {
        countriesListAdapter.submitList(countries)
    }

    override fun showLoading() = getBaseActivity().showToolbarProgress()

    override fun hideLoading() = getBaseActivity().hideToolbarProgress()

    private fun setupRecyclerView(){
        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = countriesListAdapter
        }
    }
}