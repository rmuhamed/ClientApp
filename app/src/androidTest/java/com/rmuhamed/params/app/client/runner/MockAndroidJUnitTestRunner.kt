package com.rmuhamed.params.app.client.runner

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner

class MockAndroidJUnitTestRunner: AndroidJUnitRunner() {

    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        return super.newApplication(cl,  MockClientApp::class.java.name, context)
    }
}