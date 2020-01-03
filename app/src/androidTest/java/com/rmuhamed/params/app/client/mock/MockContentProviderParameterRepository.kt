package com.rmuhamed.params.app.client.mock

import com.rmuhamed.params.providerlibrary.Param
import com.rmuhamed.params.providerlibrary.QueryObject
import com.rmuhamed.params.providerlibrary.repository.ParamFactory
import com.rmuhamed.params.providerlibrary.repository.ParameterRepository
import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Future

class MockContentProviderParameterRepository(private val executorService: ExecutorService): ParameterRepository {
    override fun update(p0: Int, p1: Param?): Future<Boolean> {
        return executorService.submit (Callable { true })
    }

    override fun add(p0: Param?): Future<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun all(): Future<MutableList<Param>> {
        return executorService.submit(Callable {
           mutableListOf<Param>(ParamFactory.create("mock", "alphanumeric"))
        })
    }

    override fun query(p0: QueryObject?): Future<MutableList<Param>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}