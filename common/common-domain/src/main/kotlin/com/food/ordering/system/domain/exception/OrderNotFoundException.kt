package com.food.ordering.system.domain.exception

class OrderNotFoundException(message: String, cause: Throwable?) : DomainException(message, cause) {
}