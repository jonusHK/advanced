package com.dhkpo.advanced.trace.hellotrace

import com.dhkpo.advanced.trace.TraceStatus
import org.junit.jupiter.api.Test

class HelloTraceV2Test {

    @Test
    fun begin_end() {
        val trace = HelloTraceV2()
        val status1: TraceStatus = trace.begin("hello")
        val status2: TraceStatus = trace.beginSync(status1.traceId, "hello2")
        trace.end(status2)
        trace.end(status1)
    }

    @Test
    fun begin_exception() {
        val trace = HelloTraceV2()
        val status1: TraceStatus = trace.begin("hello")
        val status2: TraceStatus = trace.beginSync(status1.traceId, "hello2")
        trace.exception(status2, IllegalStateException())
        trace.exception(status1, IllegalStateException())
    }
}
