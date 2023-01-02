package com.food.ordering.system.order.service.domain.dto.create

import jakarta.validation.constraints.NotNull

data class OrderAddress(@NotNull val street: String, @NotNull val postalCode: String, @NotNull val city: String) {

}
