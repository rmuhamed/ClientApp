package com.rmuhamed.params.app.client

import android.app.Application
import android.os.StrictMode
import com.rmuhamed.params.app.client.view.config.InputFieldContext
import com.rmuhamed.params.providerlibrary.Configuration
import com.rmuhamed.params.providerlibrary.ParamContract
import com.rmuhamed.params.providerlibrary.repository.ContentProviderParameterRepository
import com.rmuhamed.params.providerlibrary.repository.ParameterRepository

class ClientApp : Application() {
    lateinit var repository : ParameterRepository
    override fun onCreate() {
        super.onCreate()

        InputFieldContext.initialize()

        val configuration = Configuration.ClientBuilder()
            .build()

        repository = ContentProviderParameterRepository(this.applicationContext, configuration)

        StrictMode.ThreadPolicy.Builder()
            .penaltyLog()
            .detectAll()
    }
}