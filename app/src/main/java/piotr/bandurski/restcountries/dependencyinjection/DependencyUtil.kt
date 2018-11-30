package piotr.bandurski.restcountries.dependencyinjection

import android.app.Activity
import piotr.bandurski.restcountries.RestCountriesApplication
import piotr.bandurski.restcountries.base.BaseActivity
import toothpick.Scope
import toothpick.Toothpick
import toothpick.smoothie.module.SmoothieApplicationModule
import toothpick.smoothie.module.SmoothieSupportActivityModule

object DependencyUtil {

    private val scopes = HashMap<Activity, Scope>()

    private lateinit var appScope: Scope

    fun <T> inject(obj: T): T {
        Toothpick.inject(obj, appScope)
        return obj
    }

    fun <T> inject(activity: BaseActivity, obj: T): T{
        Toothpick.inject(obj, getScopeIfExistsOrCreateNewOne(activity))
        return obj
    }

    fun <T> getInstance(clazz: Class<T>): T {
        return appScope.getInstance(clazz)
    }

    fun <T> getInstance(clazz: Class<T>, activity: BaseActivity): T {
        return scopes[activity]!!.getInstance(clazz)
    }

    fun openScopeAndInject(activity: BaseActivity){
        val scope = Toothpick.openScopes(activity.application, activity)
        scope.installModules(SmoothieSupportActivityModule(activity), RestCountriesActivityModule(activity))
        scopes[activity] = scope
        Toothpick.inject(activity, scope)
    }

    fun closeScope(activity: BaseActivity){
        scopes.remove(activity)
        Toothpick.closeScope(activity)
    }

    private fun getScopeIfExistsOrCreateNewOne(activity: BaseActivity): Scope {
        val scope = getScope(activity)
        return if (scope === null){
            openScopeAndInject(activity)
            getScope(activity)!!
        }else scope
    }

    private fun getScope(activity: BaseActivity): Scope? = scopes[activity]

    fun createAppScopeAndInject(application: RestCountriesApplication){
        appScope = Toothpick.openScope(application)
        appScope.installModules(SmoothieApplicationModule(application), RestCountriesApplicationModule(application))
        Toothpick.inject(application, appScope)
    }

}