package com.rmuhamed.params.app.client.view

import android.text.InputType
import com.rmuhamed.params.app.client.viewobject.Format

object InputTypeProvider {

    fun get(format: Format): Int {
        return when(format) {
            Format.ALPHANUMERIC -> InputType.TYPE_CLASS_TEXT
            Format.NUMERIC -> InputType.TYPE_CLASS_NUMBER
            Format.BINARY -> InputType.TYPE_CLASS_NUMBER
            Format.IP_ADDRESS -> InputType.TYPE_CLASS_NUMBER
            Format.HEXADECIMAL -> InputType.TYPE_CLASS_NUMBER
            else -> InputType.TYPE_NULL
        }
    }

}