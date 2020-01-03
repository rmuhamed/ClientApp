package com.rmuhamed.params.app.client.runner

import android.app.Application
import com.rmuhamed.params.app.client.IClientApp
import com.rmuhamed.params.app.client.mock.MockContentProviderParameterRepository
import com.rmuhamed.params.providerlibrary.repository.ParameterRepository
import java.util.concurrent.Executors

class MockClientApp: Application(), IClientApp {
    lateinit var repository: ParameterRepository

    override fun onCreate() {
        super.onCreate()

        setupRepository()
    }

    override fun setupRepository() {
        repository = MockContentProviderParameterRepository(Executors.newSingleThreadExecutor())
    }
}