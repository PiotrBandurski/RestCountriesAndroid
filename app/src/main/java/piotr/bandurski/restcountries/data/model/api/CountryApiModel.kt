package piotr.bandurski.restcountries.data.model.api

import com.google.gson.annotations.SerializedName

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

class CountryApiModel {
    var name: String? = null

    @SerializedName("numericCode")
    var phoneCode: String? = null

    @SerializedName("flag")
    var flagUrl: String? = null

    var currencies: List<CurrencyApiModel>? = null

    @SerializedName("topLevelDomain")
    var topLevelDomains: List<String>? = null

}