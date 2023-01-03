package com.food.ordering.system.order.service.domain.dto.create

import com.food.ordering.system.domain.valueobject.OrderStatus
import jakarta.validation.constraints.NotNull
import java.util.*

data class CreateOrderResponse(
    @NotNull val orderTrackingId: UUID,
    @NotNull val orderStatus: OrderStatus,
    @NotNull val message: String = ""
) {
}