package com.rmuhamed.params.app.client.activity

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.rmuhamed.params.app.client.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_checkTitle() {
        onView(withText(R.string.demo_options)).check(matches(isDisplayed()))
    }

    @Test
    fun test_checkButtonsDisplayed() {
        onView(withText(R.string.retrieve_info_from_provider)).check(matches(isDisplayed()))
        onView(withText(R.string.add_a_new_param)).check(matches(isDisplayed()))
        onView(withText(R.string.update_a_param)).check(matches(isDisplayed()))
        onView(withText(R.string.show_a_param)).check(matches(isDisplayed()))
    }

    @Test
    fun test_checkButtonsClickable() {
        onView(withText(R.string.retrieve_info_from_provider)).check(matches(isClickable()))
        onView(withText(R.string.add_a_new_param)).check(matches(isClickable()))
        onView(withText(R.string.update_a_param)).check(matches(isClickable()))
        onView(withText(R.string.show_a_param)).check(matches(isClickable()))
    }
}