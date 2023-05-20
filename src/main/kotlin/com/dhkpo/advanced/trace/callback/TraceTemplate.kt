package com.dhkpo.advanced.trace.callback

import com.dhkpo.advanced.trace.TraceStatus
import com.dhkpo.advanced.trace.logtrace.LogTrace
import org.slf4j.LoggerFactory

class TraceTemplate(private val trace: LogTrace) {

    private val log = LoggerFactory.getLogger(this.javaClass)

    fun <T> execute(message: String, callback: TraceCallback<T>): T {
        var status: TraceStatus? = null

        try {
            status = trace.begin(message)

            // 로직 호출
            val result: T = callback.call()

            trace.end(status)
            return result

        } catch (e: Exception) {
            status?.let {
                trace.exception(status, e)
            }
            throw e
        }
    }
}
