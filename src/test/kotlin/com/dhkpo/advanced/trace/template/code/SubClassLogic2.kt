package com.dhkpo.advanced.trace.template.code

import org.slf4j.LoggerFactory

class SubClassLogic2 : AbstractTemplate() {

    private val log = LoggerFactory.getLogger(this.javaClass)

    override fun call() {
        log.info("비즈니스 로직2 실행")
    }
}