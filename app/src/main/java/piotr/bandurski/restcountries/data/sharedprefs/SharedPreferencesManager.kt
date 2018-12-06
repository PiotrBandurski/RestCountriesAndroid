package piotr.bandurski.restcountries.data.sharedprefs

import android.app.Application
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

@Singleton
class SharedPreferencesManager @Inject constructor(context: Application) {

    companion object {
        private val LAST_COUNTRIES_DOWNLOAD_TIME_STAMP = "LAST_COUNTRIES_DOWNLOAD_TIME_STAMP"
    }

    private val sharedPreferencesUtil: SharedPreferencesUtil = SharedPreferencesUtil(context)

    var lastCountiesDownloadTimeStamp
        get() = sharedPreferencesUtil.loadLong(LAST_COUNTRIES_DOWNLOAD_TIME_STAMP)
        set(newValue) = sharedPreferencesUtil.savePreference(LAST_COUNTRIES_DOWNLOAD_TIME_STAMP, newValue)

}