package com.dhkpo.advanced.app.v0

import org.springframework.stereotype.Service

@Service
class OrderServiceVO(private val orderRepository: OrderRepositoryVO) {

    fun orderItem(itemId: String) {
        orderRepository.save(itemId)
    }
}
