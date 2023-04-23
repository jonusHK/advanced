package com.dhkpo.advanced.app.v0

import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryVO {
    fun save(itemId: String) {
        if (itemId == "ex") {
            throw IllegalStateException("예외 발생!")
         }
    }

    fun sleep(millis: Long) {
        try {
            Thread.sleep(millis)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}
