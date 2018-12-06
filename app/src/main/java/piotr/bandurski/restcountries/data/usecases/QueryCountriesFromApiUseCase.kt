package piotr.bandurski.restcountries.data.usecases

import android.text.TextUtils
import io.reactivex.Single
import piotr.bandurski.restcountries.data.model.database.Country
import piotr.bandurski.restcountries.data.repository.CountryRepository
import piotr.bandurski.restcountries.data.usecases.base.SingleUseCase
import javax.inject.Inject

/**
 * Created by Piotr Bandurski on 02/12/2018.
 */

class QueryCountriesFromApiUseCase @Inject constructor(private val countryRepository: CountryRepository): SingleUseCase<List<Country>, QueryCountriesFromApiUseCase.Params>() {

    override fun buildUseCaseObservable(params: Params?): Single<List<Country>> {
        if (TextUtils.isEmpty(params?.query)){
            return countryRepository.getAllCountriesFromApi()
        }
        return countryRepository.queryCountriesByName(params?.query)
    }

    class Params(val query: String?)
}