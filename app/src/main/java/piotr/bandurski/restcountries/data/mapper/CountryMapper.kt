package piotr.bandurski.restcountries.data.mapper

import piotr.bandurski.restcountries.data.model.api.CountryApiModel
import piotr.bandurski.restcountries.data.model.api.CurrencyApiModel
import piotr.bandurski.restcountries.data.model.database.Country
import piotr.bandurski.restcountries.data.model.database.Currency
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */
@Singleton
class CountryMapper @Inject constructor() {

    fun mapCountries(apiModels: List<CountryApiModel>): List<Country> {
        return apiModels.map {
            Country(
                name = it.name,
                phoneCode = it.phoneCode,
                flagUrl = it.flagUrl,
                topLevelDomain = it.topLevelDomains?.first()
            ).apply {
                mapCurrencies(it.currencies)?.let {
                    currencies.addAll(it)
                }
            }
        }
    }

    fun mapCurrencies(apiModels: List<CurrencyApiModel>?): List<Currency>? {
        return apiModels?.map {
            Currency(
                name = it.name,
                symbol = it.symbol,
                code = it.code
            )
        }
    }
}