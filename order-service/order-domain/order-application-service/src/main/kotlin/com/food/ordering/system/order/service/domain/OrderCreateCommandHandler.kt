package com.food.ordering.system.order.service.domain

import com.food.ordering.system.domain.exception.OrderDomainException
import com.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand
import com.food.ordering.system.order.service.domain.dto.create.CreateOrderResponse
import com.food.ordering.system.order.service.domain.entity.Order
import com.food.ordering.system.order.service.domain.entity.Restaurant
import com.food.ordering.system.order.service.domain.mapper.OrderDataMapper
import com.food.ordering.system.order.service.domain.ports.output.repository.CustomerRepository
import com.food.ordering.system.order.service.domain.ports.output.repository.OrderRepository
import com.food.ordering.system.order.service.domain.ports.output.repository.RestaurantRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Component
class OrderCreateCommandHandler(
    @Autowired
    val orderDomainService: OrderDomainService,
    @Autowired
    val orderRepository: OrderRepository,
    @Autowired
    val customerRepository: CustomerRepository,
    @Autowired
    val restaurantRepository: RestaurantRepository,
    @Autowired
    val orderDataMapper: OrderDataMapper
) {

    @Transactional
    fun createOrder(createOrderCommand: CreateOrderCommand): CreateOrderResponse {
        checkCustomer(createOrderCommand.customerId)
        val restaurant = checkRestaurant(createOrderCommand);
        val order = orderDataMapper.createOrderCommandToOrder(createOrderCommand)
        val orderCreatedEvent = orderDomainService.validateAndInitiateOrder(order, restaurant)
        val orderSaveResult = saveOrder(order)
        return orderDataMapper.orderToCreateOrderResponse(orderSaveResult)
    }

    private fun saveOrder(order: Order): Order {
        val orderResult = orderRepository.save(order)
        if (orderResult.isEmpty) {
            throw OrderDomainException("Could not save order");
        }
        return orderResult.get()
    }

    private fun checkRestaurant(createOrderCommand: CreateOrderCommand): Restaurant {
        val restaurant = orderDataMapper.createOrderCommandToRestaurant(createOrderCommand)
        val optionalRestaurant = restaurantRepository.findRestaurantInfo(restaurant)
        if (optionalRestaurant.isEmpty) {
            throw OrderDomainException(
                "Could not find restaurant with restaurant id ${createOrderCommand.restaurantId}",
                null
            )
        }
        return optionalRestaurant.get()
    }

    private fun checkCustomer(customerId: UUID) {
        val optionalCustomer = customerRepository.findCustomer(customerId)
        if (optionalCustomer.isEmpty) {
            throw OrderDomainException("Could not find customer with customer id $customerId", null)
        }
    }
}