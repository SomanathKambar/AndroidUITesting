package com.example.androiduitesting


import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.Toolbar
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule @JvmField
    val  activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)
    @Test
    fun greet() {
        Espresso.onView(withId(R.id.greetMessageView)).check(ViewAssertions.matches(
            withText(R.string.hello_world)))
        Espresso.onView(withId(R.id.greetButton)).perform(ViewActions.click())
            .check(ViewAssertions.matches(isNotEnabled()))
        Espresso.onView(withId(R.id.greetMessageView)).check(ViewAssertions.matches(
            withText(R.string.hello)))
    }

    @Test
    fun toolbarTitle() {
        //to get the view0 without id
        Espresso.onView(
            allOf(
                isAssignableFrom(AppCompatTextView::class.java),
                withParent(isAssignableFrom(Toolbar::class.java))
            )
        ).check(ViewAssertions.matches(withText(R.string.title)))
    }

    @Test
    fun toolBarTitleWithCustomMatcher(){
        val title = InstrumentationRegistry.getInstrumentation().targetContext.getString(R.string.title)
        Espresso.onView(isAssignableFrom(Toolbar::class.java))
            .check(ViewAssertions.matches(withToolbarTitle(title)))
    }

    private fun withToolbarTitle(expectedTitle: String): Matcher<View>{
        return object : BoundedMatcher<View, Toolbar>(Toolbar::class.java){
            /**
             * Generates a description of the object.  The description may be part of a
             * a description of a larger object of which this is just a component, so it
             * should be worded appropriately.
             *
             * @param description
             * The description to be built or appended to.
             */
            override fun describeTo(description: Description?) {
                description?.appendText("with toolbar text : $expectedTitle")
            }

            override fun matchesSafely(toolbar: Toolbar?): Boolean {
                return expectedTitle == toolbar?.title
            }

        }
    }

    @Test
    fun clickItem() {
        //this confirms footer is not visible
        Espresso.onView(withId(R.id.footer))
            .check(ViewAssertions.matches(not(isDisplayed())))
        //this scrolls to 27th position and performs click
        Espresso.onView(withId(R.id.recycler_view))
            .perform(RecyclerViewActions.actionOnItemAtPosition<TextViewHolder>(27, ViewActions.click()))
//this confirms footer is  visible
        Espresso.onView(withId(R.id.footer))
            .check(ViewAssertions.matches(withText("27")))
            .check(ViewAssertions.matches(isDisplayed()))
    }
}