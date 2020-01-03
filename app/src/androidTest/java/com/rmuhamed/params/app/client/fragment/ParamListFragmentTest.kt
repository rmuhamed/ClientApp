package com.rmuhamed.params.app.client.fragment

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.rmuhamed.params.app.client.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ParamListFragmentTest {

    @Test
    fun test_checkTitleIsDisplayed() {
        launchFragmentInContainer<ParamListFragment>()
        onView(withId(R.id.param_list_title))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_checkList() {
        launchFragmentInContainer<ParamListFragment>()

        onView(withId(R.id.param_list))
            .check(matches(isDisplayed()))

        onView(withId(R.id.param_list))
            .check(matches(hasChildCount(12)))
    }
}