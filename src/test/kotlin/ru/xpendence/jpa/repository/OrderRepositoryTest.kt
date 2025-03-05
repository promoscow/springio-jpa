package ru.xpendence.jpa.repository

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional
import ru.xpendence.jpa.JpaApplicationTests
import java.util.UUID
import kotlin.test.assertTrue

class OrderRepositoryTest : JpaApplicationTests() {

    @Autowired
    private lateinit var orderRepository: OrderRepository

    @Test
    @DisplayName("getRestaurants(): проблема N + 1. Проверяем, был ли пользователь в ресторане")
    @Transactional
    fun getRestaurants() {
        val userId = UUID.fromString("1031f963-957c-425f-962e-767080a699cb")
        val orders = orderRepository.getOrdersByUserId(userId)
        val dishes = orders.mapNotNull { it.dish }
        val restaurants = dishes.mapNotNull { it.restaurant }

        assertTrue { restaurants.map { it.name }.contains("Три поросёнка") }
    }
}