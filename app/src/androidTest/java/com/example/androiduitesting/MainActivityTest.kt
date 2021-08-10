package com.example.androiduitesting

import android.service.autofill.Validators
import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import javax.xml.validation.Validator

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule @JvmField
    val  activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)
    @Test
    fun greet() {
        Espresso.onView(ViewMatchers.withId(R.id.greetMessageView)).check(ViewAssertions.matches(
            ViewMatchers.withText(R.string.hello_world)))
        Espresso.onView(ViewMatchers.withId(R.id.greetButton)).perform(ViewActions.click())
            .check(ViewAssertions.matches(ViewMatchers.isNotEnabled()))
        Espresso.onView(ViewMatchers.withId(R.id.greetMessageView)).check(ViewAssertions.matches(
            ViewMatchers.withText(R.string.hello)))
    }
}