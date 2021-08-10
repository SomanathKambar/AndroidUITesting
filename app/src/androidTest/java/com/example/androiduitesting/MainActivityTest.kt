package com.example.androiduitesting


import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.Toolbar
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

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

    @Test
    fun toolbarTitle() {
        //to get the view without id
        Espresso.onView(
            allOf(
                isAssignableFrom(AppCompatTextView::class.java),
                ViewMatchers.withParent(isAssignableFrom(Toolbar::class.java))
            )
        ).check(ViewAssertions.matches(withText(R.string.title)))
    }
}