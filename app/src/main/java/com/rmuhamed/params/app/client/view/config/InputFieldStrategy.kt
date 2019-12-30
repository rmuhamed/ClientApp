package com.rmuhamed.params.app.client.view.config

import android.content.Context
import android.view.View
import com.rmuhamed.params.app.client.viewobject.Param

interface InputFieldStrategy<out ViewType: View> {
    fun execute(context: Context, param: Param) : ViewType
}