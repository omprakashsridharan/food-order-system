package com.food.ordering.system.domain.valueobject

import java.math.BigDecimal
import java.math.RoundingMode

data class Money(private val amount: BigDecimal) {

    companion object {
        val ZERO: Money = Money(BigDecimal.ZERO)
    }

    fun isGreaterThanZero(): Boolean {
        return this.amount > BigDecimal.ZERO
    }

    fun isGreaterThan(money: Money): Boolean {
        return this.amount > money.amount
    }

    fun add(money: Money): Money {
        return Money(setScale(this.amount.add(money.amount)))
    }

    fun subtract(money: Money): Money {
        return Money(setScale(this.amount.subtract(money.amount)))
    }

    fun multiply(multiplier: Int): Money {
        return Money(setScale(this.amount.multiply(BigDecimal(multiplier))))
    }

    private fun setScale(input: BigDecimal): BigDecimal {
        return input.setScale(2, RoundingMode.HALF_EVEN)
    }
}