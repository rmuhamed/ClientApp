package com.rmuhamed.params.app.client.ext

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.matcher.BoundedMatcher
import com.rmuhamed.params.app.client.fragment.ParamListAdapter
import org.hamcrest.Description
import org.hamcrest.Matcher

class RecyclerMatcherTextAt(private val position: Int, private val matcher: Matcher<View>): BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
    override fun describeTo(description: Description?) {
        matcher.describeTo(description)
    }

    override fun matchesSafely(recyclerView: RecyclerView?): Boolean {
        val item: ParamListAdapter.ViewHolder? =
            requireNotNull(recyclerView)
                .findViewHolderForAdapterPosition(position) as ParamListAdapter.ViewHolder?

        val label = (requireNotNull(item).itemView) as AppCompatTextView

        return matcher.matches(label)
    }
}