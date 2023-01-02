package com.food.ordering.system.order.service.domain.dto.create

import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.util.*

data class OrderItem(
    @NotNull val productId: UUID,
    @NotNull val quantity: Int,
    @NotNull val price: BigDecimal,
    @NotNull val subTotal: BigDecimal
) {

}
