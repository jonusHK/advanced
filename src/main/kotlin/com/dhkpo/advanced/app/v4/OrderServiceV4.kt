package com.dhkpo.advanced.app.v4

import com.dhkpo.advanced.trace.logtrace.LogTrace
import com.dhkpo.advanced.trace.template.AbstractTemplate
import org.springframework.stereotype.Service

@Service
class OrderServiceV4(private val orderRepository: OrderRepositoryV4, private val trace: LogTrace) {

    fun orderItem(itemId: String) {

        val template = object: AbstractTemplate<Unit>(trace) {
            override fun call() {
                orderRepository.save(itemId)
            }
        }

        template.execute("OrderService.orderItem()")
    }
}
