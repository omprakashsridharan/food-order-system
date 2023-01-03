package com.food.ordering.system.order.service.domain

import com.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand
import com.food.ordering.system.order.service.domain.dto.create.CreateOrderResponse
import com.food.ordering.system.order.service.domain.mapper.OrderDataMapper
import com.food.ordering.system.order.service.domain.ports.output.message.publisher.payment.OrderCreatedPaymentRequestMessagePublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class OrderCreateCommandHandler(
    @Autowired
    val orderCreateHelper: OrderCreateHelper,
    @Autowired
    val orderDataMapper: OrderDataMapper,
    @Autowired
    val orderCreatedPaymentRequestMessagePublisher: OrderCreatedPaymentRequestMessagePublisher
) {

    fun createOrder(createOrderCommand: CreateOrderCommand): CreateOrderResponse {
        val orderCreatedEvent = orderCreateHelper.persistOrder(createOrderCommand)
        orderCreatedPaymentRequestMessagePublisher.publish(orderCreatedEvent)
        return orderDataMapper.orderToCreateOrderResponse(orderCreatedEvent.order)
    }

}