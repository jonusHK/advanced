package com.dhkpo.advanced.app.v1

import com.dhkpo.advanced.trace.TraceStatus
import com.dhkpo.advanced.trace.hellotrace.HelloTraceV1
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderControllerV1(private val orderService: OrderServiceV1, private val trace: HelloTraceV1) {

    @GetMapping("/v1/request")
    fun request(itemId: String): String {
        var status: TraceStatus? = null
        try {
            status = trace.begin("OrderController.request()")
            orderService.orderItem(itemId)
            trace.end(status)
        } catch (e: Exception) {
            status?.let {
                trace.exception(status, e)
            }
            throw e
        }
        return "ok"
    }
}
