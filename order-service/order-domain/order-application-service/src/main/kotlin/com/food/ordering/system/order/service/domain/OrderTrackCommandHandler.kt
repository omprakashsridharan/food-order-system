package com.food.ordering.system.order.service.domain

import com.food.ordering.system.order.service.domain.dto.track.TrackOrderQuery
import com.food.ordering.system.order.service.domain.dto.track.TrackOrderResponse
import org.springframework.stereotype.Component

@Component
class OrderTrackCommandHandler {
    fun trackOrder(trackOrderQuery: TrackOrderQuery): TrackOrderResponse {}
}