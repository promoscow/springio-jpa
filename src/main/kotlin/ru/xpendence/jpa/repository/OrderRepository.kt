package ru.xpendence.jpa.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.xpendence.jpa.domain.Order
import java.util.UUID

interface OrderRepository : JpaRepository<Order, UUID> {

    fun getOrdersByUserId(userId: UUID): List<Order>
}