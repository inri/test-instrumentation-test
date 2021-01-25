package com.solutiance.dach

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class User : RealmObject() {

    @PrimaryKey
    var email: String = UUID.randomUUID().toString()

    var name: String? = null

    fun changeName(newName: String) {
        name = newName
    }
}
