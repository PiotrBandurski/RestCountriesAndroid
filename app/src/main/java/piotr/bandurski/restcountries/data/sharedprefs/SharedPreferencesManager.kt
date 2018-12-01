package piotr.bandurski.restcountries.data.sharedprefs

import android.content.Context
import javax.inject.Inject

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

class SharedPreferencesManager @Inject constructor(private val context: Context) {

    companion object {
        private val LAST_COUNTRIES_DOWNLOAD_TIME_STAMP = "LAST_COUNTRIES_DOWNLOAD_TIME_STAMP"
    }

    private val sharedPreferencesUtil: SharedPreferencesUtil = SharedPreferencesUtil(context)

    var lastCountiesDownloadTimeStamp
        get() = sharedPreferencesUtil.loadLong(LAST_COUNTRIES_DOWNLOAD_TIME_STAMP)
        set(newValue) = sharedPreferencesUtil.savePreference(LAST_COUNTRIES_DOWNLOAD_TIME_STAMP, newValue)

}