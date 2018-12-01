package piotr.bandurski.restcountries.data.database

import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmModel
import io.realm.Sort

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

abstract class RealmDatabaseHelper {

    companion object {

        @JvmStatic
        protected fun getLikeQueryString(like: String): String {
            var likeString = like
            likeString = likeString.replace("*", "")
            likeString = likeString.replace("?", "")
            return "*$likeString*"
        }

    }

    protected val realmConfiguration: RealmConfiguration

    init{
        realmConfiguration = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(realmConfiguration)
    }

    private fun getRealm(): Realm {
        return Realm.getInstance(realmConfiguration)
    }

    protected fun saveObjects(realmModels: List<RealmModel>) {
        val realmInstance = getRealm()
        realmInstance.beginTransaction()
        realmInstance.copyToRealmOrUpdate(realmModels)
        realmInstance.commitTransaction()
        realmInstance.close()
    }

    protected fun saveObject(realmModel: RealmModel) {
        val realmInstance = getRealm()
        realmInstance.beginTransaction()
        realmInstance.copyToRealmOrUpdate(realmModel)
        realmInstance.commitTransaction()
        realmInstance.close()
    }

    protected fun <T : RealmModel> deleteAllObjectsFromTable(clazz: Class<T>) {
        val realm = getRealm()
        realm.beginTransaction()
        realm.delete(clazz)
        realm.commitTransaction()
        realm.close()
    }

    protected fun <T : RealmModel> findAll(clazz: Class<T>): List<T> {
        val realm = getRealm()
        var realmObjects: List<T> = realm.where(clazz).findAll()

        realmObjects = realm.copyFromRealm(realmObjects)
        realm.close()

        return realmObjects
    }

}