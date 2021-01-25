package com.solutiance.dach.realmtests

import com.solutiance.dach.BaseRealmTest
import com.solutiance.dach.User
import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(androidx.test.ext.junit.runners.AndroidJUnit4::class)
class UserTest : BaseRealmTest() {


    @Test
    fun test_creation() {
        testRealm.executeTransaction { inRealm ->

            TestCase.assertEquals(0, testRealm.where(User::class.java).findAll().size)

            inRealm.copyToRealm(User())

            TestCase.assertEquals(1, testRealm.where(User::class.java).findAll().size)
        }
    }

    @Test
    fun test_name() {
        testRealm.executeTransaction { inRealm ->
            val user = inRealm.copyToRealm(User())

            TestCase.assertNull(user.name)

            user.changeName("test")

            TestCase.assertEquals("test", user.name)
        }
    }
}