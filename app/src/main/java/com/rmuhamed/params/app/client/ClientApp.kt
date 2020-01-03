package com.rmuhamed.params.app.client

import android.app.Application
import com.rmuhamed.params.app.client.view.config.InputFieldContext
import com.rmuhamed.params.providerlibrary.Configuration
import com.rmuhamed.params.providerlibrary.repository.ContentProviderParameterRepository
import com.rmuhamed.params.providerlibrary.repository.ParameterRepository
import java.util.concurrent.Executors

class ClientApp : Application(), IClientApp {
    lateinit var repository : ParameterRepository
    override fun onCreate() {
        super.onCreate()

        InputFieldContext.initialize()

        setupRepository()
    }

    override fun setupRepository() {
        repository = ContentProviderParameterRepository(
            this.applicationContext,
            Executors.newFixedThreadPool(4),
            Configuration.ClientBuilder().build())
    }
}