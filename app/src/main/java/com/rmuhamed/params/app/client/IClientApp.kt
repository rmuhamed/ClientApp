package com.rmuhamed.params.app.client

import com.rmuhamed.params.providerlibrary.repository.ParameterRepository

interface IClientApp {
    fun configureInputField()
    fun initRepository(): ParameterRepository
}