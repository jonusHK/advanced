package com.dhkpo.advanced.app.v5

import com.dhkpo.advanced.trace.callback.TraceTemplate
import com.dhkpo.advanced.trace.logtrace.LogTrace
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryV5(private val trace: LogTrace) {

    private var traceTemplate: TraceTemplate = TraceTemplate(trace)

    fun save(itemId: String) {

        traceTemplate.execute("OrderRepository.save()") {
            if (itemId == "ex") throw IllegalStateException("예외 발생!")
            sleep(1000)
        }
    }

    fun sleep(millis: Long) {

        try {
            Thread.sleep(millis)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}
