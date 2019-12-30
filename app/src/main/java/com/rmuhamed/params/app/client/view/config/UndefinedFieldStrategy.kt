package com.rmuhamed.params.app.client.view.config

import android.content.Context
import android.view.View
import com.rmuhamed.params.app.client.viewobject.Param

class UndefinedFieldStrategy : InputFieldStrategy<View> {
    override fun execute(context: Context, param: Param): View {
        throw UnsupportedOperationException("Not ready yet")
    }
}