package piotr.bandurski.restcountries.presentation.list

import io.reactivex.observers.DisposableSingleObserver
import piotr.bandurski.restcountries.base.BasePresenter
import piotr.bandurski.restcountries.data.model.database.Country
import piotr.bandurski.restcountries.data.usecases.GetAllCountriesSingleUseCase
import piotr.bandurski.restcountries.util.ApiErrorUtil
import javax.inject.Inject

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

class CountriesListPresenter @Inject constructor(private val getAllCountriesSingleUseCase: GetAllCountriesSingleUseCase,
                                                 private val apiErrorUtil: ApiErrorUtil) : BasePresenter<CountriesListContract.View>(), CountriesListContract.Presenter {

    override fun loadCountries() {
        view?.showLoading()
        getAllCountriesSingleUseCase.execute(GetAllCountriesSingleObserver())
    }

    override fun detachView() {
        view?.hideLoading()
        getAllCountriesSingleUseCase.clear()
        super.detachView()
    }

    inner class GetAllCountriesSingleObserver: DisposableSingleObserver<List<Country>>(){

        override fun onSuccess(t: List<Country>) {
            view?.run {
                hideLoading()
                bindCountriesToView(t)
            }
        }

        override fun onError(e: Throwable) {
            view?.run {
                hideLoading()
                showError(apiErrorUtil.getSuitableErrorMessage(e))
            }
        }
    }
}