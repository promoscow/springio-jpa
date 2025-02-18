package ru.xpendence.jpa.repository

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional
import ru.xpendence.jpa.JpaApplicationTests
import java.util.UUID

class RestaurantRepositoryTest : JpaApplicationTests() {

    @Autowired
    private lateinit var repository: RestaurantRepository

    @Test
    @DisplayName("update(): ничего не обновляет при наличии транзакции")
    @Transactional
    fun update() {
        val restaurant = repository.findById(UUID.fromString("3367ca7f-13a2-439b-925d-5fd479f33ab4")).get()
        restaurant.name = "${restaurant.name} ${kotlin.random.Random.nextInt(100)}"
        repository.save(restaurant)
    }
}