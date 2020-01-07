package com.rmuhamed.params.app.client.fragment

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.rmuhamed.params.app.client.R
import com.rmuhamed.params.app.client.activity.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ParamListFragmentTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setup() {
        onView(withId(R.id.fetch_params_button)).perform(click())
    }

    @Test
    fun test_checkTitleIsDisplayed() {
        onView(withId(R.id.param_list_title))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_checkList() {
        onView(withId(R.id.param_list))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_checkListLength() {
        onView(withId(R.id.param_list))
            .perform(RecyclerViewActions.scrollToPosition<ParamListAdapter.ViewHolder>(16))
        //TODO: check a good way to check length

    }
}