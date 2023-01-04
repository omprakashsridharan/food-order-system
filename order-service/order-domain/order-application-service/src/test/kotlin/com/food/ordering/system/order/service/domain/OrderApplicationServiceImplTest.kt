package com.food.ordering.system.order.service.domain

import io.mockk.mockk
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired

internal class OrderApplicationServiceImplTest {
    val orderCreateCommandHandler: OrderCreateCommandHandler = mockk()
    val orderTrackCommandHandler: OrderTrackCommandHandler = mockk()

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun createOrder() {
    }

    @Test
    fun trackOrder() {
    }
}