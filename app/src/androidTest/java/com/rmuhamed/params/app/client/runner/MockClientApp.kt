package com.rmuhamed.params.app.client.runner

import com.rmuhamed.params.app.client.FrameworkClientApp
import com.rmuhamed.params.app.client.mock.MockContentProviderParameterRepository
import com.rmuhamed.params.providerlibrary.repository.ParameterRepository
import java.util.concurrent.Executors

class MockClientApp: FrameworkClientApp() {
    override fun configureInputField() {}

    override fun initRepository(): ParameterRepository =
        MockContentProviderParameterRepository(Executors.newSingleThreadExecutor())
}