package com.food.ordering.system.order.service.domain

import com.food.ordering.system.domain.exception.OrderNotFoundException
import com.food.ordering.system.order.service.domain.dto.track.TrackOrderQuery
import com.food.ordering.system.order.service.domain.dto.track.TrackOrderResponse
import com.food.ordering.system.order.service.domain.mapper.OrderDataMapper
import com.food.ordering.system.order.service.domain.ports.output.repository.OrderRepository
import com.food.ordering.system.order.service.domain.valueobject.TrackingId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class OrderTrackCommandHandler(
    @Autowired
    val orderRepository: OrderRepository,
    @Autowired
    val orderDataMapper: OrderDataMapper
) {
    @Transactional(readOnly = true)
    fun trackOrder(trackOrderQuery: TrackOrderQuery): TrackOrderResponse {
        val optionalOrder = orderRepository.findByTrackingId(TrackingId(trackOrderQuery.orderTrackingId))
        if (optionalOrder.isEmpty) {
            throw OrderNotFoundException("Order not found", null)
        }
        return orderDataMapper.orderToTrackOrderResponse(optionalOrder.get())
    }
}