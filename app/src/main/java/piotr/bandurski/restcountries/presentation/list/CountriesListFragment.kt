package piotr.bandurski.restcountries.presentation.list

import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.brandongogetap.stickyheaders.StickyLayoutManager
import kotlinx.android.synthetic.main.countries_list_fragment_layout.*
import piotr.bandurski.restcountries.C
import piotr.bandurski.restcountries.R
import piotr.bandurski.restcountries.base.BaseMVPViewFragment
import piotr.bandurski.restcountries.base.MvpPresenter
import piotr.bandurski.restcountries.presentation.list.adapter.CountriesListAdapter
import piotr.bandurski.restcountries.presentation.list.adapter.viewmodel.AbstractCountryListViewModel
import javax.inject.Inject

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

class CountriesListFragment @Inject constructor(): BaseMVPViewFragment(R.layout.countries_list_fragment_layout), CountriesListContract.View {

    @Inject
    lateinit var presenter: CountriesListContract.Presenter

    @Inject
    lateinit var countriesListAdapter: CountriesListAdapter

    private val countriesViewModel by lazy {
        ViewModelProviders.of(this).get(CountriesListViewModel::class.java)
    }

    override fun getPresenter(): MvpPresenter<Nothing> = presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        presenter.loadCountries()
    }

    override fun getViewModel() = countriesViewModel

    override fun bindCountriesToView(countiesListViewModels: List<AbstractCountryListViewModel>) {
        countriesListAdapter.submitList(countiesListViewModels)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putParcelable(C.Parcerable.RECYCLER_VIEW_POSSITION, recyclerView.layoutManager?.onSaveInstanceState())
        super.onSaveInstanceState(outState)
    }

    override fun showLoading() = getBaseActivity().showToolbarProgress()

    override fun hideLoading() = getBaseActivity().hideToolbarProgress()

    private fun setupRecyclerView(savedInstanceState: Bundle?){
        recyclerView.apply {
            layoutManager = StickyLayoutManager(requireContext(), countriesListAdapter)
            adapter = countriesListAdapter
        }
        bindCountriesToView(countriesViewModel.countriesListViewModels)
        savedInstanceState?.getParcelable<Parcelable>(C.Parcerable.RECYCLER_VIEW_POSSITION)?.let {
            recyclerView.layoutManager?.onRestoreInstanceState(it)
        }
    }
}