package piotr.bandurski.restcountries.data.usecases.base

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

/**
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This interface represents a execution unit for different use cases (this means any use case
 * in the application should implement this contract).
 *
 * By convention each ObservableUseCase implementation will return the result using a [DisposableObserver]
 * that will execute its job in a background thread and will post the result in the UI thread.
 */
abstract class SingleUseCase<T, Params> internal constructor(): AbstractDisposableUseCase()  {

    protected open val executionThread: Scheduler = Schedulers.io()
    protected open val postExecutionThread: Scheduler = AndroidSchedulers.mainThread()

    /**
     * Builds an [Observable] which will be used when executing the current [SingleUseCase].
     */
    internal abstract fun buildUseCaseObservable(params: Params? = null): Single<T>

    /**
     * Executes the current use case.
     *
     * @param observer [DisposableObserver] which will be listening to the observable build
     * by [.buildUseCaseCompletable] ()} method.
     * @param params Parameters (Optional) used to build/execute this use case.
     */
    fun execute(observer: DisposableSingleObserver<T>, params: Params? = null) {
        var single = this.buildUseCaseObservable(params)
            .subscribeOn(executionThread)
            .observeOn(postExecutionThread)
        single = applyAdditionalFunctionsOnSingle(params, single)
        addDisposable(single.subscribeWith(observer))
    }

    protected open fun applyAdditionalFunctionsOnSingle(params: Params?, single: Single<T>) = single

}