package com.dhkpo.advanced.app.v5

import com.dhkpo.advanced.trace.callback.TraceTemplate
import com.dhkpo.advanced.trace.logtrace.LogTrace
import org.springframework.stereotype.Service

@Service
class OrderServiceV5(private val orderRepository: OrderRepositoryV5, private val trace: LogTrace) {

    private var traceTemplate: TraceTemplate = TraceTemplate(trace)

    fun orderItem(itemId: String) {

        traceTemplate.execute("OrderService.orderItem()") {
            orderRepository.save(itemId)
        }
    }
}
