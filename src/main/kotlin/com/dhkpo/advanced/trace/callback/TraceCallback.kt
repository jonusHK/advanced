package com.dhkpo.advanced.trace.callback

fun interface TraceCallback<T> {
    fun call(): T
}
