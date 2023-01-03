package com.food.ordering.system.domain.event.publisher

import com.food.ordering.system.domain.event.DomainEvent

interface DomainEventPublisher<T, E> where T : DomainEvent<E> {
    fun publish(domainEvent: T)
}