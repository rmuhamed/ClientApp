package com.rmuhamed.params.app.client.view.config

import com.rmuhamed.params.app.client.viewobject.Format

object InputFieldContext {
    private val strategies = hashMapOf<String, InputFieldStrategy<*>>()
    private val availableFormats = Format.values()

    fun initialize() {
        for (format in availableFormats) {
            when(format) {
                Format.ALPHANUMERIC,
                Format.NUMERIC,
                Format.NUMERIC_OR_BLANK ->
                    strategies.put(format.name, AlphanumericFieldStrategy())
                Format.IP_ADDRESS ->
                    strategies.put(format.name, IpAddressFieldStrategy())
                else -> strategies.put(format.name, UndefinedFieldStrategy())
            }
        }
    }

    fun by(format: Format) : InputFieldStrategy<*> =
        strategies.get(format.name) ?: UndefinedFieldStrategy()

}