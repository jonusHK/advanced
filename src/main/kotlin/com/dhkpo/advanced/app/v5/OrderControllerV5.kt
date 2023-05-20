package com.dhkpo.advanced.app.v5

import com.dhkpo.advanced.trace.callback.TraceTemplate
import com.dhkpo.advanced.trace.logtrace.LogTrace
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderControllerV5(private val orderService: OrderServiceV5, private val trace: LogTrace) {

    private var traceTemplate: TraceTemplate = TraceTemplate(trace)

    @GetMapping("/v5/request")
    fun request(itemId: String): String {

        return traceTemplate.execute("OrderController.request()") {
            orderService.orderItem(itemId)
            "ok"
        }
    }
}
