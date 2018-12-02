package piotr.bandurski.restcountries.presentation.list.adapter.viewholder

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ahmadrosid.svgloader.SvgLoader
import kotlinx.android.synthetic.main.countries_list_item_layout.view.*
import piotr.bandurski.restcountries.R
import piotr.bandurski.restcountries.data.model.database.Country
import piotr.bandurski.restcountries.presentation.list.adapter.viewmodel.AbstractCountryListViewModel

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

class CountryViewHolder private constructor(itemView: View, private val activity: Activity): AbstractCountryListViewHolder(itemView) {


    companion object {
        fun create(parent: ViewGroup, activity: Activity): CountryViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.countries_list_item_layout, parent, false)
            return CountryViewHolder(view, activity)
        }
    }

    override fun bindItemToView(item: AbstractCountryListViewModel) {
        item.country?.let { bindCountryToView(it) }
    }

    private fun bindCountryToView(country: Country){
        itemView.apply {
            countryNameTextView.text = country.name
            currencyTextView.text = country.currencies.map { it.code }.joinToString()
            phoneNumberCodeTextView.text = country.phoneCode
            internetDomainNameTextView.text = country.topLevelDomain
            country.flagUrl?.let {
                SvgLoader.pluck()
                    .with(activity)
                    .load(it, flagImageView)
            }
        }
    }
}