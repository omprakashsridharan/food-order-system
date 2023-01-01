package com.food.ordering.system.order.service.domain.event

import com.food.ordering.system.domain.event.DomainEvent
import com.food.ordering.system.order.service.domain.entity.Order
import java.time.ZonedDateTime

abstract class OrderEvent(val order: Order, var createdAt: ZonedDateTime): DomainEvent<Order> {
}