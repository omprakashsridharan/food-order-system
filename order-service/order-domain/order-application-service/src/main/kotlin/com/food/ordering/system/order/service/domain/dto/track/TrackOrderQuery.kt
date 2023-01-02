package com.food.ordering.system.order.service.domain.dto.track

import jakarta.validation.constraints.NotNull
import java.util.*

data class TrackOrderQuery(@NotNull val orderTrackingId: UUID) {
}