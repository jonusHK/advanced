package com.dhkpo.advanced.trace.strategy

import com.dhkpo.advanced.trace.strategy.code.strategy.ContextV2
import com.dhkpo.advanced.trace.strategy.code.strategy.Strategy
import com.dhkpo.advanced.trace.strategy.code.strategy.StrategyLogic1
import com.dhkpo.advanced.trace.strategy.code.strategy.StrategyLogic2
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

class ContextV2Test {

    private val log = LoggerFactory.getLogger(this.javaClass)

    /**
     * 전략 패턴 사용
     */
    @Test
    fun strategyV1() {
        val context = ContextV2()
        context.execute(StrategyLogic1())
        context.execute(StrategyLogic2())
    }

    /**
     * 전략 패턴 사용 익명 내부 클래스
     */
    @Test
    fun strategyV2() {
        val context = ContextV2()
        context.execute { log.info("비즈니스 로직1 실행") }
        context.execute { log.info("비즈니스 로직2 실행") }
    }
}