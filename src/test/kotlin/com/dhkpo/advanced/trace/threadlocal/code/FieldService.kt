package com.dhkpo.advanced.trace.threadlocal.code

import org.slf4j.LoggerFactory

class FieldService {

    private val log = LoggerFactory.getLogger(this.javaClass)
    private var nameStore: String? = null

    fun logic(name: String): String {
        log.info("저장 name={} --> nameStore={}", name, nameStore)
        nameStore = name
        sleep(1000)
        log.info("조회 nameStore={}", nameStore)
        return nameStore!!
    }

    private fun sleep(millis: Int) {
        try {
            Thread.sleep(millis.toLong())
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}