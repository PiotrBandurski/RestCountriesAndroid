package piotr.bandurski.restcountries.data.sharedprefs

import android.content.Context
import android.content.SharedPreferences
import java.util.HashSet
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

@Singleton
class SharedPreferencesUtil @Inject constructor(val context: Context) {

    companion object {
        const val DEFAULT_STRING_VALUE = ""
        const val DEFAULT_BOOLEAN_VALUE = false
        const val DEFAULT_LONG_VALUE: Long = -1
        const val DEFAULT_FLOAT_VALUE: Float = -1f
        const val DEFAULT_INT_VALUE = -1

        private const val PREFERENCE_FILE_KEY = "piotr.bandurski.restcountries.PREFERENCE_FILE_KEY"

        fun getSharedPreferences(context: Context) : SharedPreferences {
            return context.getSharedPreferences(PREFERENCE_FILE_KEY, Context.MODE_PRIVATE)
        }
    }

    fun savePreference(key: String, value: String?) {
        val sharedPreferences = getSharedPreferences(context)
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun savePreference(key: String, valuesList: Set<String>) {
        val sharedPreferences = getSharedPreferences(context)
        val editor = sharedPreferences.edit()
        editor.putStringSet(key, valuesList)
        editor.apply()
    }

    fun savePreference(key: String, value: Int) {
        val sharedPreferences = getSharedPreferences(context)
        val editor = sharedPreferences.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    fun savePreference(key: String, value: Float) {
        val sharedPreferences = getSharedPreferences(context)
        val editor = sharedPreferences.edit()
        editor.putFloat(key, value)
        editor.apply()
    }

    fun savePreference(key: String, value: Long) {
        val sharedPreferences = getSharedPreferences(context)
        val editor = sharedPreferences.edit()
        editor.putLong(key, value)
        editor.apply()
    }

    fun savePreference(key: String, value: Boolean) {
        val sharedPreferences = getSharedPreferences(context)
        val editor = sharedPreferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun loadString(key: String, defaultValue: String) : String? {
        val sharedPreferences = getSharedPreferences(context)
        return sharedPreferences.getString(key, defaultValue)
    }

    fun loadString(key: String) : String? {
        return loadString(key, DEFAULT_STRING_VALUE)
    }

    fun loadStringSet(key: String): MutableSet<String>? {
        val sharedPreferences = getSharedPreferences(context)
        return sharedPreferences.getStringSet(key, HashSet())
    }

    fun loadInt(key: String, defaultValue: Int) : Int {
        val sharedPreferences = getSharedPreferences(context)
        return sharedPreferences.getInt(key, defaultValue)
    }

    fun loadInt(key: String) : Int {
        return loadInt(key, DEFAULT_INT_VALUE)
    }

    fun loadFloat(key: String, defaultValue: Float) : Float {
        val sharedPreferences = getSharedPreferences(context)
        return sharedPreferences.getFloat(key, defaultValue)
    }

    fun loadFloat(key: String) : Float {
        return loadFloat(key, DEFAULT_FLOAT_VALUE)
    }

    fun loadLong(key: String, defaultValue: Long) : Long {
        val sharedPreferences = getSharedPreferences(context)
        return sharedPreferences.getLong(key, defaultValue)
    }

    fun loadLong(key: String) : Long {
        return loadLong(key, DEFAULT_LONG_VALUE)
    }

    fun loadBoolean(key: String, defaultValue: Boolean) : Boolean {
        val sharedPreferences = getSharedPreferences(context)
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    fun loadBoolean(key: String) : Boolean {
        return loadBoolean(key, DEFAULT_BOOLEAN_VALUE)
    }

    fun clear() {
        val sharedPreferences = getSharedPreferences(context)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }
}