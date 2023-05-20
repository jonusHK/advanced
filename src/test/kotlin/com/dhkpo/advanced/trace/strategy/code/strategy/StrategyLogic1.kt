package com.dhkpo.advanced.trace.strategy.code.strategy

import org.slf4j.LoggerFactory

class StrategyLogic1 : Strategy {

    private val log = LoggerFactory.getLogger(this.javaClass)

    override fun call() {
        log.info("비즈니스 로직1 실행")
    }
}
