package com.food.ordering.system.order.service.domain.mapper

import com.food.ordering.system.domain.valueobject.CustomerId
import com.food.ordering.system.domain.valueobject.Money
import com.food.ordering.system.domain.valueobject.ProductId
import com.food.ordering.system.domain.valueobject.RestaurantId
import com.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand
import com.food.ordering.system.order.service.domain.dto.create.CreateOrderResponse
import com.food.ordering.system.order.service.domain.dto.create.OrderAddress
import com.food.ordering.system.order.service.domain.dto.create.OrderItem
import com.food.ordering.system.order.service.domain.dto.track.TrackOrderResponse
import com.food.ordering.system.order.service.domain.entity.Order
import com.food.ordering.system.order.service.domain.entity.Product
import com.food.ordering.system.order.service.domain.entity.Restaurant
import com.food.ordering.system.order.service.domain.valueobject.OrderItemId
import com.food.ordering.system.order.service.domain.valueobject.StreetAddress
import org.springframework.stereotype.Component
import java.util.*
import java.util.stream.Collectors
import com.food.ordering.system.order.service.domain.entity.OrderItem as OrderItemEntity

@Component
class OrderDataMapper {
    fun createOrderCommandToRestaurant(createOrderCommand: CreateOrderCommand): Restaurant {
        val products =
            createOrderCommand.items.stream().map { Product(ProductId(it.productId)) }.collect(Collectors.toList())
        val restaurantId = RestaurantId(createOrderCommand.restaurantId)
        return Restaurant(id = restaurantId, products = products)
    }

    fun createOrderCommandToOrder(createOrderCommand: CreateOrderCommand): Order {
        val customerId = CustomerId(createOrderCommand.customerId)
        val restaurantId = RestaurantId(createOrderCommand.restaurantId)
        val deliveryAddress = orderAddressToStreetAddress(createOrderCommand.address)
        val price = Money(createOrderCommand.price)
        val items = orderItemsToOrderItemEntities(createOrderCommand.items)
        return Order(
            customerId = customerId,
            restaurantId = restaurantId,
            streetAddress = deliveryAddress,
            price = price,
            items = items
        )
    }

    private fun orderItemsToOrderItemEntities(items: List<OrderItem>): List<OrderItemEntity> {
        return items.mapIndexed { index, it ->
            val product = Product(ProductId(it.productId))
            val price = Money(it.price)
            val quantity = it.quantity
            val subTotal = Money(it.subTotal)
            // TODO: REFACTOR LATER
            val orderItemId = OrderItemId(index.toLong())
            return@mapIndexed OrderItemEntity(
                product = product,
                price = price,
                quantity = quantity,
                subTotal = subTotal,
                id = orderItemId
            )
        }
    }

    private fun orderAddressToStreetAddress(address: OrderAddress): StreetAddress {
        return StreetAddress(
            id = UUID.randomUUID(),
            street = address.street,
            postalCode = address.postalCode,
            city = address.city
        )
    }

    fun orderToCreateOrderResponse(order: Order, message: String): CreateOrderResponse {
        return CreateOrderResponse(orderTrackingId = order.trackingId.value, orderStatus = order.orderStatus, message = message)
    }

    fun orderToTrackOrderResponse(order: Order): TrackOrderResponse {
        return TrackOrderResponse(
            orderTrackingId = order.trackingId.value,
            orderStatus = order.orderStatus,
            failureMessages = order.failureMessages
        )
    }
}