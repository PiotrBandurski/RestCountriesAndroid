package piotr.bandurski.restcountries.presentation.list.adapter

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.brandongogetap.stickyheaders.exposed.StickyHeaderHandler
import piotr.bandurski.restcountries.data.model.database.Country
import piotr.bandurski.restcountries.presentation.list.adapter.viewholder.AbstractCountryListViewHolder
import piotr.bandurski.restcountries.presentation.list.adapter.viewholder.CountryViewHolder
import piotr.bandurski.restcountries.presentation.list.adapter.viewholder.HeaderViewHolder
import piotr.bandurski.restcountries.presentation.list.adapter.viewmodel.AbstractCountryListViewModel
import javax.inject.Inject

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

class CountriesListAdapter @Inject constructor(private val activity: Activity):
    ListAdapter<AbstractCountryListViewModel, AbstractCountryListViewHolder>(CountryDiffCallback), StickyHeaderHandler {

    private var _items: List<AbstractCountryListViewModel>? = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbstractCountryListViewHolder{
        return if (viewType == AbstractCountryListViewModel.COUNTRY_CELL) {
            CountryViewHolder.create(parent, activity)
        } else HeaderViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: AbstractCountryListViewHolder, position: Int) = holder.bindItemToView(getItem(position))

    override fun getItemViewType(position: Int) = getItem(position).viewType

    override fun submitList(list: List<AbstractCountryListViewModel>?) { //we need to get access to adapter data, unfortunetly its private in ListAdapter
        super.submitList(list)
        _items = list
    }

    override fun getAdapterData() = _items
}

object CountryDiffCallback: DiffUtil.ItemCallback<AbstractCountryListViewModel>(){

    override fun areItemsTheSame(oldItem: AbstractCountryListViewModel, newItem: AbstractCountryListViewModel): Boolean {
        return oldItem.viewType == newItem.viewType
                && (oldItem.country?.name == newItem.country?.name
                || oldItem.headerLabel != null && oldItem.headerLabel == newItem.headerLabel) //we don't have objects id's but I think that we can use name as id :)
    }

    override fun areContentsTheSame(oldItem: AbstractCountryListViewModel, newItem: AbstractCountryListViewModel): Boolean {
        return (oldItem.country?.name == newItem.country?.name
            && oldItem.country?.flagUrl == newItem.country?.flagUrl)
                || (oldItem.headerLabel != null && oldItem.headerLabel == newItem.headerLabel)
    }

}