package com.dhkpo.advanced.trace.template.code

import org.slf4j.LoggerFactory

abstract class AbstractTemplate {

    private val log = LoggerFactory.getLogger(this.javaClass)

    fun execute() {
        val startTime = System.currentTimeMillis()
        // 비즈니스 로직 실행
        call()
        // 비즈니스 로직 종료
        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        log.info("resultTime={}", resultTime)
    }

    protected open fun call() {}
}
