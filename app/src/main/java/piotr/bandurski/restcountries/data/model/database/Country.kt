package piotr.bandurski.restcountries.data.model.database

import io.realm.RealmList
import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

@RealmClass
open class Country(
    @PrimaryKey var name: String? = null,
    var phoneCode: String? = null,
    var flagUrl: String? = null,
    var currencies: RealmList<Currency> = RealmList(),
    var topLevelDomain: String? = null
) : RealmModel