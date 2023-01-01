package com.food.ordering.system.domain.exception

open class DomainException(override val message: String, override val cause: Throwable?) : RuntimeException(message) {
}