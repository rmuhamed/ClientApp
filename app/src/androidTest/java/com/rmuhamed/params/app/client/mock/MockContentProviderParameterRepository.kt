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
        return executorService.submit (Callable { true })
    }

    override fun all(): Future<MutableList<Param>> {
        return executorService.submit(Callable {
           mutableListOf<Param>(
               ParamFactory.create("1", "numeric"),
               ParamFactory.create("2", "numeric"),
               ParamFactory.create("3", "numeric"),
               ParamFactory.create("4", "numeric"),
               ParamFactory.create("5", "numeric"),
               ParamFactory.create("6", "numeric"),
               ParamFactory.create("7", "numeric"),
               ParamFactory.create("8", "numeric"),
               ParamFactory.create("9", "numeric"),
               ParamFactory.create("10", "numeric"),
               ParamFactory.create("11", "numeric"),
               ParamFactory.create("12", "numeric")
           )
        })
    }

    override fun query(p0: QueryObject?): Future<MutableList<Param>> {
        return executorService.submit(Callable {
            mutableListOf<Param>(
                ParamFactory.create("2", "numeric")
            )
        })
    }
}