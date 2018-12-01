package piotr.bandurski.restcountries.util.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by Piotr Bandurski  on 01/12/2018.
 */

fun ImageView.loadSvgFromWeb(url: String?){
    if (url == null){
        setImageDrawable(null)
        return
    }
    Glide.with(context).load(url).into(this)
}