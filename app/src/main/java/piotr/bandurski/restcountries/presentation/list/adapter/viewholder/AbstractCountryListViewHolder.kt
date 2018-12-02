package piotr.bandurski.restcountries.presentation.list.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import piotr.bandurski.restcountries.presentation.list.adapter.viewmodel.AbstractCountryListViewModel

/**
 * Created by Piotr Bandurski  on 02/12/2018.
 */

abstract class AbstractCountryListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    abstract fun bindItemToView(item: AbstractCountryListViewModel)

}