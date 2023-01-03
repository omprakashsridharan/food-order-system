package com.food.ordering.system.order.service.domain.ports.output.repository

import com.food.ordering.system.order.service.domain.entity.Order
import com.food.ordering.system.order.service.domain.valueobject.TrackingId
import java.util.*

interface OrderRepository {
    fun save(order: Order): Optional<Order>
    fun findByTrackingId(trackingId: TrackingId): Optional<Order>
}