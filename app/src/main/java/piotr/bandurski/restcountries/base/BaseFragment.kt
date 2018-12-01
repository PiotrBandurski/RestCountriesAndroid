package piotr.bandurski.restcountries.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.annotation.LayoutRes
import piotr.bandurski.restcountries.dependencyinjection.DependencyUtil

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

abstract class BaseFragment(@LayoutRes val layoutId: Int): Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            DependencyUtil.inject(getBaseActivity(),this)
        }
    }

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId, container, false)
    }

    protected fun getBaseActivity(): BaseActivity = activity as BaseActivity

}