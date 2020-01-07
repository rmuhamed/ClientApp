package com.rmuhamed.params.app.client

import android.app.Application
import com.rmuhamed.params.providerlibrary.repository.ParameterRepository

abstract class FrameworkClientApp: Application(), IClientApp {
    lateinit var repository: ParameterRepository

    override fun onCreate() {
        super.onCreate()

        configureInputField()
        repository = initRepository()
    }
}