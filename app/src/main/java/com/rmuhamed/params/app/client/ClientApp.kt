package com.rmuhamed.params.app.client

import com.rmuhamed.params.app.client.view.config.InputFieldContext
import com.rmuhamed.params.providerlibrary.Configuration
import com.rmuhamed.params.providerlibrary.repository.ContentProviderParameterRepository
import com.rmuhamed.params.providerlibrary.repository.ParameterRepository
import java.util.concurrent.Executors

class ClientApp : FrameworkClientApp() {

    override fun configureInputField() {
        InputFieldContext.initialize()
    }

    override fun initRepository(): ParameterRepository {
        return ContentProviderParameterRepository(
            applicationContext,
            Executors.newFixedThreadPool(4),
            Configuration.ClientBuilder().build())
    }
}