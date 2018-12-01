package piotr.bandurski.restcountries.base

import androidx.annotation.CallSuper

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

abstract class BasePresenter<T : MvpView> : MvpPresenter<T> {

    var view: T? = null
        private set

    fun isViewAttached(): Boolean = view != null

    @CallSuper
    override fun attachView(mvpView: T) {
        view = mvpView
    }

    @CallSuper
    override fun detachView() {
        view = null
    }

    fun checkViewAttached() {
        if (!isViewAttached()) throw MvpViewNotAttachedException()
    }

    class MvpViewNotAttachedException : RuntimeException("Please call Controller.attachView(MvcView) before" + " requesting data to the Controller")

}