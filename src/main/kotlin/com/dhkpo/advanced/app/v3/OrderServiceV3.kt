package com.dhkpo.advanced.app.v3

import com.dhkpo.advanced.trace.TraceStatus
import com.dhkpo.advanced.trace.logtrace.LogTrace
import org.springframework.stereotype.Service

@Service
class OrderServiceV3(private val orderRepository: OrderRepositoryV3, private val trace: LogTrace) {

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
