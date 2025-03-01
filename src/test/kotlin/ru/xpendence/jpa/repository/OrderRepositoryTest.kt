package ru.xpendence.jpa.repository

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional
import ru.xpendence.jpa.JpaApplicationTests
import ru.xpendence.jpa.domain.Dish
import ru.xpendence.jpa.domain.Order
import ru.xpendence.jpa.domain.User
import java.time.LocalDate
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

    @Test
    @DisplayName("updateOrder(): пытаемся обновить заказ")
    fun updateOrder() {
        val user = User(
            id = UUID.randomUUID(),
            username = "test",
            password = "test"
        )
        val dish = Dish(
            id = UUID.randomUUID(),
            version = 0
        )
        val orderId = UUID.fromString("7f81aed1-1f99-4c7a-b325-d78a31abe590")
        val order = Order(
            id = orderId,
            date = LocalDate.now().minusDays(1)
        )
//        val stored = orderRepository.findById(orderId).get()
//        Order.enrichForUpdate(order, stored)
        orderRepository.save(order)
    }
}