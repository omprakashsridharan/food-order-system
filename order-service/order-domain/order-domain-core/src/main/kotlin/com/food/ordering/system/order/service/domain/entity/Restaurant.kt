package com.food.ordering.system.order.service.domain.entity

import com.food.ordering.system.domain.entity.AggregateRoot
import com.food.ordering.system.domain.valueobject.RestaurantId

class Restaurant(val id: RestaurantId, val products: List<Product>, val active: Boolean = true) :
    AggregateRoot<RestaurantId>(id) {
}