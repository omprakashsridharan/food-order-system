package com.food.ordering.system.order.service.domain.dto.track

import com.food.ordering.system.domain.valueobject.OrderStatus
import jakarta.validation.constraints.NotNull
import java.util.*

data class TrackOrderResponse(
    @NotNull val orderTrackingId: UUID,
    @NotNull val orderStatus: OrderStatus,
    val failureMessages: List<String>
) {
}