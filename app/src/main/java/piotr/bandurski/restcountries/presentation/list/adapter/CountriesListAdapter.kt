package piotr.bandurski.restcountries.presentation.list.adapter

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import piotr.bandurski.restcountries.data.model.database.Country
import javax.inject.Inject

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

class CountriesListAdapter @Inject constructor(private val activity: Activity): ListAdapter<Country, CountryViewHolder>(CountryDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CountryViewHolder.create(parent, activity)

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) = holder.bindCountryToView(getItem(position))

}

object CountryDiffCallback: DiffUtil.ItemCallback<Country>(){

    override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
        return oldItem.name == newItem.name //we don't have objects id's but I think that we can use name as id :)
    }

    override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
        return oldItem.name == newItem.name
            && oldItem.flagUrl == newItem.flagUrl
        //TODO compare rest of items which can change
    }

}