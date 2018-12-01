package piotr.bandurski.restcountries.data.usecases

import io.reactivex.Single
import piotr.bandurski.restcountries.C
import piotr.bandurski.restcountries.data.model.database.Country
import piotr.bandurski.restcountries.data.repository.CountryRepository
import piotr.bandurski.restcountries.data.sharedprefs.SharedPreferencesManager
import piotr.bandurski.restcountries.data.usecases.base.SingleUseCase
import java.util.*
import javax.inject.Inject

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

class GetAllCountriesSingleUseCase @Inject constructor(private val countryRepository: CountryRepository,
                                                       private val sharedPreferencesManager: SharedPreferencesManager): SingleUseCase<List<Country>, Nothing?>() {

    override fun buildUseCaseObservable(params: Nothing?): Single<List<Country>> {
        return if (shouldDownloadNewDataAfterExpire()){
            countryRepository
                .getAllCountriesFromApi()
                .doOnSuccess {
                    countryRepository.saveAllCountriesToDatabase(it)
                    sharedPreferencesManager.lastCountiesDownloadTimeStamp = Date().time
                }
        } else Single.fromCallable { countryRepository.getAllCountriesFromDatabase() }
    }

    private fun shouldDownloadNewDataAfterExpire()
            = Date().time > sharedPreferencesManager.lastCountiesDownloadTimeStamp + C.Data.EXPIRY_TIME

}