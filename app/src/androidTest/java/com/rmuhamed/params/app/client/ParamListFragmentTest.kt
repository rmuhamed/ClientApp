package com.rmuhamed.params.app.client

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.rmuhamed.params.app.client.fragment.ParamListFragment
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ParamListFragmentTest {

    @Test
    fun test_checkTitleDisplayed() {
        val scenario = launchFragmentInContainer<ParamListFragment>()

        onView(withId(R.id.param_list_title))
            .check(matches(isDisplayed()))

    }
}