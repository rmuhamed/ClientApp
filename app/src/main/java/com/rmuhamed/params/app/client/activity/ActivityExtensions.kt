package com.rmuhamed.params.app.client.activity

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

fun <T : Fragment> FragmentActivity.replaceContainerWith(
    @IdRes containerId: Int,
    tag: String?, args: Bundle? = null,
    fragmentClass: Class<T>
) {
    val fragmentInstance = getFragmentBy(tag, fragmentClass)

    args?.let {
        fragmentInstance.arguments = it
    }

    supportFragmentManager.beginTransaction().apply {
        replace(containerId, fragmentInstance, tag)
        commit()
    }
}

private fun <T : Fragment> FragmentActivity.getFragmentBy(
    tag: String?,
    fragmentClass: Class<T>
): Fragment =
    supportFragmentManager.findFragmentByTag(tag) ?: fragmentClass.newInstance()