package com.solutiance.dach

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import io.realm.Realm
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before

/*
    https://developer.android.com/training/testing/unit-testing/instrumented-unit-tests?authuser=1

    IMPORTANT NOTES
    - The instrumented tests need an empty databse, so run on a fresh App/Device (uninstall previous installed
      BV/Dach Apps, otherwise existing data might change the test results).
 */
open class BaseRealmTest {

    lateinit var appContext: Context

    init {
        initAppContext()
    }

    private fun initAppContext() {
        // Context of the app under test.
        appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.solutiance.dach.develop", appContext.packageName)

        Realm.init(appContext)
    }

    lateinit var testRealm: Realm

    @Before
    fun initAndCleanupRealm() {
        testRealm = Realm.getDefaultInstance()

        testRealm.executeTransaction { inRealm ->
            inRealm.deleteAll()
        }
    }

    @After
    fun closeRealm() {
        testRealm.close()
    }
}