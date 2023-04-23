package com.dhkpo.advanced.app.v1

import com.dhkpo.advanced.trace.TraceStatus
import com.dhkpo.advanced.trace.hellotrace.HelloTraceV1
import org.springframework.stereotype.Service

@Service
class OrderServiceV1(private val orderRepository: OrderRepositoryV1, private val trace: HelloTraceV1) {

    fun orderItem(itemId: String) {
        var status: TraceStatus? = null
        try {
            status = trace.begin("OrderService.orderItem()")
            orderRepository.save(itemId)
            trace.end(status)
        } catch (e: Exception) {
            status?.let {
                trace.exception(status, e)
            }
            throw e
        }
    }
}
