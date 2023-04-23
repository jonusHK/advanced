package com.dhkpo.advanced.trace.threadlocal

import com.dhkpo.advanced.trace.threadlocal.code.FieldService
import com.dhkpo.advanced.trace.threadlocal.code.ThreadLocalService
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

class ThreadLocalServiceTest {

    private val log = LoggerFactory.getLogger(this.javaClass)
    private val service = ThreadLocalService()

    @Test
    fun field() {
        log.info("main start")
        val userA = Runnable {
            service.logic("userA")
        }
        val userB = Runnable {
            service.logic("userB")
        }

        val threadA = Thread(userA)
        val threadB = Thread(userB)

        threadA.name = "thread-A"
        threadB.name = "thread-B"

        threadA.start()
        sleep(100)
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
