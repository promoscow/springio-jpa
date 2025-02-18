package ru.xpendence.jpa.repository

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import ru.xpendence.jpa.JpaApplicationTests
import java.util.UUID
import kotlin.random.Random

class DishRepositoryTest : JpaApplicationTests() {

    @Autowired
    private lateinit var repository: DishRepository

    @Test
    @DisplayName("update(): 3 селекта + 1 update, обновилось version")
    fun update() {
        val dish = repository.findDishById(UUID.fromString("2f3cedce-ad2d-4782-98c6-c0f62b8a3f5c"))
        dish.name = "Мясо по-бразильски + ${Random.nextInt(10)}"
        repository.saveAndFlush(dish)
    }
}