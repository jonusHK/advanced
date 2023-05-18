package com.dhkpo.advanced.app.v4

import com.dhkpo.advanced.trace.logtrace.LogTrace
import com.dhkpo.advanced.trace.template.AbstractTemplate
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryV4(private val trace: LogTrace) {
    fun save(itemId: String) {

        val template = object: AbstractTemplate<Unit>(trace) {
            override fun call() {
                if (itemId == "ex") throw IllegalStateException("예외 발생!")
                sleep(1000)
            }
        }

        template.execute("OrderRepository.save()")
    }

    fun sleep(millis: Long) {
        try {
            Thread.sleep(millis)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}
