package com.dhkpo.advanced.trace.template

import com.dhkpo.advanced.trace.TraceStatus
import com.dhkpo.advanced.trace.logtrace.LogTrace

abstract class AbstractTemplate<T>(private val trace: LogTrace) {

    fun execute(message: String): T {
        var status: TraceStatus? = null

        try {
            status = trace.begin(message)

            // 로직 호출
            val result: T = call()

            trace.end(status)
            return result

        } catch (e: Exception) {
            status?.let {
                trace.exception(status, e)
            }
            throw e
        }
    }

    protected abstract fun call(): T
}
