package com.solutiance.dach

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class DachApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initRealm("dach")
    }

    private fun initRealm(realmDatabaseName: String) {
        Realm.init(this)

        //TODO ROOFAPP-979: use encryptionKey!
        // see https://realm.io/docs/java/2.0.0/api/io/realm/RealmConfiguration.Builder.html

        // The Realm file will be located in Context.getFilesDir() with name "realmDatabaseName.realm"
        val config = RealmConfiguration.Builder()
            .name("$realmDatabaseName.realm")
            .deleteRealmIfMigrationNeeded()
            .build()

        // Use the config
        Realm.setDefaultConfiguration(config)
    }
}
