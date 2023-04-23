package com.dhkpo.advanced.trace.logtrace

import com.dhkpo.advanced.trace.TraceStatus

interface LogTrace {
    fun begin(message: String): TraceStatus

    fun end(status: TraceStatus)

    fun exception(status: TraceStatus, e: Exception)
}
