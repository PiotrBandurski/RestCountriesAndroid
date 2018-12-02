package piotr.bandurski.restcountries.presentation.list.adapter.viewholder

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.countires_list_header_item_layout.view.*
import piotr.bandurski.restcountries.R
import piotr.bandurski.restcountries.presentation.list.adapter.viewmodel.AbstractCountryListViewModel

/**
 * Created by Piotr Bandurski  on 02/12/2018.
 */

class HeaderViewHolder private constructor(itemView: View): AbstractCountryListViewHolder(itemView) {

    companion object {
        fun create(parent: ViewGroup): HeaderViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.countires_list_header_item_layout, parent, false)
            return HeaderViewHolder(view)
        }
    }

    override fun bindItemToView(item: AbstractCountryListViewModel) {
        itemView.headerTextView.text = item.headerLabel
    }

}