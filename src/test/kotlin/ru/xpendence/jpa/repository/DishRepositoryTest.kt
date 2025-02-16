package ru.xpendence.jpa.repository

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional
import ru.xpendence.jpa.JpaApplicationTests
import kotlin.test.assertEquals

class DishRepositoryTest : JpaApplicationTests() {

    @Autowired
    private lateinit var repository: DishRepository

    @Test
    @DisplayName("getVisits(): проблема N + 1. Проверяем количество заказов на Харчо с изюминкой")
    @Transactional
    fun getVisits() {
        val dish = repository.findDishByName("Харчо с изюминкой")
        val ordersCount = dish.restaurant!!.orders.size
        assertEquals(2, ordersCount)
    }
}