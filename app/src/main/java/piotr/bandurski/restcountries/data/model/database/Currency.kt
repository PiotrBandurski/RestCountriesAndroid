package piotr.bandurski.restcountries.data.model.database

import io.realm.RealmModel
import io.realm.annotations.RealmClass

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

@RealmClass
open class Currency(
    var name: String? = null,
    var symbol: String? = null,
    var code: String? = null
) : RealmModel