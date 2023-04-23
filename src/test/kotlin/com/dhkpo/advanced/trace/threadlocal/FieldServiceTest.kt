package com.dhkpo.advanced.trace.threadlocal

import com.dhkpo.advanced.trace.threadlocal.code.FieldService
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

class FieldServiceTest {

    private val log = LoggerFactory.getLogger(this.javaClass)
    private val fieldService = FieldService()

    @Test
    fun field() {
        log.info("main start")
        val userA = Runnable {
            fieldService.logic("userA")
        }
        val userB = Runnable {
            fieldService.logic("userB")
        }

        val threadA = Thread(userA)
        val threadB = Thread(userB)

        threadA.name = "thread-A"
        threadB.name = "thread-B"

        threadA.start()
        sleep(2000) // 동시성 문제 발생 X
        threadB.start()

        sleep(3000)
        log.info("main exit")
    }

    private fun sleep(millis: Int) {
        try {
            Thread.sleep(millis.toLong())
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}
