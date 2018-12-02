package piotr.bandurski.restcountries.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.toolbar.*
import piotr.bandurski.restcountries.R
import piotr.bandurski.restcountries.dependencyinjection.DependencyUtil

abstract class BaseActivity(@LayoutRes private val layoutRes: Int = R.layout.base_activity_layout) : AppCompatActivity() {

    private val fragmentId: Int
        get() = R.id.fragmentList

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DependencyUtil.openScopeAndInject(this)
        setContentView(layoutRes)
        setSupportActionBar(toolbar)
        setTitle(R.string.app_name)
        bindOnClickListeners()
        collectExtras()
    }

    @CallSuper
    public override fun onDestroy() {
        super.onDestroy()
        DependencyUtil.closeScope(this)
    }

    fun showToolbarProgress(){
        actionBarProgress?.visibility = View.VISIBLE
    }

    fun hideToolbarProgress(){
        actionBarProgress?.visibility = View.INVISIBLE
    }

    protected fun bindOnClickListeners(){}

    protected fun collectExtras(){}

    fun openFragment(fragmentToOpen: Fragment) {
        val fragMan = supportFragmentManager
        val fragTransaction = fragMan.beginTransaction()
        fragTransaction.replace(fragmentId, fragmentToOpen, fragmentToOpen.javaClass.simpleName)
        fragTransaction.addToBackStack(fragmentToOpen.javaClass.simpleName)
        fragTransaction.commit()
    }
}