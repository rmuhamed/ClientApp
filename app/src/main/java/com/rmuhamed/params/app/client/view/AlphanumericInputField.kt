package com.rmuhamed.params.app.client.view

import android.content.Context
import android.text.InputFilter
import androidx.appcompat.widget.AppCompatEditText
import com.rmuhamed.params.app.client.R
import com.rmuhamed.params.app.client.viewobject.ConfigurationViewObject


class AlphanumericInputField(
    private val readOnly: Boolean,
    private val config: ConfigurationViewObject,
    private val inputTypeFormat: Int,
    context: Context
) : AppCompatEditText(context) {

    init {
        val configView = inflate(context, R.layout.alphanumeric_input_field, null)
                as AppCompatEditText

        configView.also {
            hint = "A value with a maximum ${config.maxLength} characters"
            inputType = inputTypeFormat
            setText(config.defaultValue ?: "")
            setSelection(config.defaultValue?.length ?: 0)
            filters = getFilters(config)
            setFocusable(!readOnly)
            setFocusableInTouchMode(!readOnly)
            setClickable(!readOnly)
        }
    }

    private fun getFilters(config: ConfigurationViewObject) =
        Array<InputFilter> (1) { InputFilter.LengthFilter(config.maxLength) }

}