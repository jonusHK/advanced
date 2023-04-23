package com.dhkpo.advanced.app.v2

import com.dhkpo.advanced.trace.TraceId
import com.dhkpo.advanced.trace.TraceStatus
import com.dhkpo.advanced.trace.hellotrace.HelloTraceV2
import org.springframework.stereotype.Service

@Service
class OrderServiceV2(private val orderRepository: OrderRepositoryV2, private val trace: HelloTraceV2) {

    fun orderItem(traceId: TraceId, itemId: String) {
        var status: TraceStatus? = null
        try {
            status = trace.beginSync(traceId, "OrderService.orderItem()")
            orderRepository.save(traceId, itemId)
            trace.end(status)
        } catch (e: Exception) {
            status?.let {
                trace.exception(status, e)
            }
            throw e
        }
    }
}
