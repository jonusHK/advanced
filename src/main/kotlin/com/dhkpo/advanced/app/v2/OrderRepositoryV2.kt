package com.dhkpo.advanced.app.v2

import com.dhkpo.advanced.trace.TraceId
import com.dhkpo.advanced.trace.TraceStatus
import com.dhkpo.advanced.trace.hellotrace.HelloTraceV2
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryV2(private val trace: HelloTraceV2) {
    fun save(traceId: TraceId, itemId: String) {
        var status: TraceStatus? = null
        try {
            status = trace.beginSync(traceId.createNextId(), "OrderRepository.save()")
            if (itemId == "ex") {
                throw IllegalStateException("예외 발생!")
            }
            sleep(1000)
            trace.end(status)
        } catch (e: Exception) {
            status?.let {
                trace.exception(status, e)
            }
            throw e
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
