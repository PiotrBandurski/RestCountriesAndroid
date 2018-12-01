package piotr.bandurski.restcountries.data.usecases.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

abstract class AbstractDisposableUseCase {

    private val disposables = CompositeDisposable()

    fun remove(disposable: Disposable) = disposables.remove(disposable)

    fun clear() = disposables.clear()

    fun haveDisposables() = disposables.size() > 0

    protected fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

}