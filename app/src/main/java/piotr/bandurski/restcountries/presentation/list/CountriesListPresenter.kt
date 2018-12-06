package piotr.bandurski.restcountries.presentation.list

import io.reactivex.observers.DisposableSingleObserver
import piotr.bandurski.restcountries.base.BasePresenter
import piotr.bandurski.restcountries.data.model.database.Country
import piotr.bandurski.restcountries.data.usecases.GetAllCountriesSingleUseCase
import piotr.bandurski.restcountries.data.usecases.QueryCountriesFromApiUseCase
import piotr.bandurski.restcountries.util.ApiErrorUtil
import retrofit2.HttpException
import javax.inject.Inject

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

class CountriesListPresenter @Inject constructor(private val getAllCountriesSingleUseCase: GetAllCountriesSingleUseCase,
                                                 private val queryCountriesFromApiUseCase: QueryCountriesFromApiUseCase,
                                                 private val apiErrorUtil: ApiErrorUtil) : BasePresenter<CountriesListContract.View>(), CountriesListContract.Presenter {

    override fun loadCountries() {
        view?.showLoading()
        getAllCountriesSingleUseCase.execute(GetAllCountriesSingleObserver())
    }

    override fun queryCountries(query: String?) {
        view?.showLoading()
        queryCountriesFromApiUseCase.execute(QueryCountriesSingleObserver(), QueryCountriesFromApiUseCase.Params(query))
    }

    override fun detachView() {
        view?.hideLoading()
        getAllCountriesSingleUseCase.clear()
        super.detachView()
    }

     open inner class GetAllCountriesSingleObserver: DisposableSingleObserver<List<Country>>(){

        override fun onSuccess(t: List<Country>) {
            view?.run {
                if (t.isEmpty()){
                    showNoCountriesFoundInfo()
                } else{
                    hideNoCountriesFoundInfo()
                }
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

    inner class QueryCountriesSingleObserver: GetAllCountriesSingleObserver(){

        override fun onError(e: Throwable) {
            if (e is HttpException && e.code() == 404){
                view?.showNoCountriesFoundInfo()
            }
            super.onError(e)
        }

    }
}