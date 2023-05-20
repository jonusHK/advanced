package com.dhkpo.advanced.trace.template

import com.dhkpo.advanced.trace.template.code.AbstractTemplate
import com.dhkpo.advanced.trace.template.code.SubClassLogic1
import com.dhkpo.advanced.trace.template.code.SubClassLogic2
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

class TemplateMethodTest {

    private val log = LoggerFactory.getLogger(this.javaClass)

    @Test
    fun templateMethodV0() {
        logic1()
        logic2()
    }

    private fun logic2() {
        val startTime = System.currentTimeMillis()
        // 비즈니스 로직 실행
        log.info("비즈니스 로직1 실행")
        // 비즈니스 로직 종료
        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        log.info("resultTime={}", resultTime)
    }

    private fun logic1() {
        val startTime = System.currentTimeMillis()
        // 비즈니스 로직 실행
        log.info("비즈니스 로직2 실행")
        // 비즈니스 로직 종료
        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        log.info("resultTime={}", resultTime)
    }

    /**
     * 템플릿 메서드 패턴 적용
     */
    @Test
    fun templateMethodV1() {
        val template1 = SubClassLogic1()
        template1.execute()

        val template2 = SubClassLogic2()
        template2.execute()
    }

    /**
     * 템플릿 메서드 패턴 적용 (익명 클래스)
     */
    @Test
    fun templateMethodV2() {
        val template1 = object: AbstractTemplate() {
            override fun call() {
                log.info("비즈니스 로직1 실행")
            }
        }
        template1.execute()

        val template2 = object: AbstractTemplate() {
            override fun call() {
                log.info("비즈니스 로직2 실행")
            }
        }
        template2.execute()
    }
}