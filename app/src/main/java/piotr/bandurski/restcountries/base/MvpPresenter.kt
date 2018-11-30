package piotr.bandurski.restcountries.base


interface MvpPresenter<in V : MvpView> {

    fun attachView(mvpView: V)

    fun detachView()
}
