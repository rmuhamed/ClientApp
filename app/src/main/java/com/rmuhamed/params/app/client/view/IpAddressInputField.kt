package com.rmuhamed.params.app.client.view

import android.content.Context
import android.text.InputType
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.LinearLayoutCompat
import com.rmuhamed.params.app.client.R

class IpAddressInputField(context: Context, readOnly: Boolean) : LinearLayoutCompat(context) {

    init {
        val view = inflate(context, R.layout.ip_address_input_field, null) as LinearLayoutCompat

        IntRange(0, view.childCount).forEach { position ->
            if (view.getChildAt(position) is AppCompatEditText) {
                (view.getChildAt(position) as AppCompatEditText).also {
                    it.inputType = InputType.TYPE_CLASS_NUMBER
                    it.setFocusable(!readOnly)
                    it.setFocusableInTouchMode(!readOnly)
                    it.setClickable(!readOnly)
                }
            }
        }

    }
}