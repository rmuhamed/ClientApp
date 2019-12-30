package com.rmuhamed.params.app.client.view.config

import android.content.Context
import androidx.appcompat.widget.AppCompatEditText
import com.rmuhamed.params.app.client.viewobject.Param
import com.rmuhamed.params.app.client.viewobject.justReadOnly
import com.rmuhamed.params.app.client.view.AlphanumericInputField
import com.rmuhamed.params.app.client.view.InputTypeProvider

class AlphanumericFieldStrategy : InputFieldStrategy<AppCompatEditText> {
    override fun execute(context: Context, param: Param): AppCompatEditText {
        val inputType = InputTypeProvider.get(param.format)
        return AlphanumericInputField(param.justReadOnly(), param.config, inputType, context)
    }
}