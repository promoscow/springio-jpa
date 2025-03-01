package ru.xpendence.jpa.repository

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import ru.xpendence.jpa.JpaApplicationTests
import java.util.UUID
import kotlin.random.Random
import kotlin.test.assertEquals

class DishRepositoryTest : JpaApplicationTests() {

    @Autowired
    private lateinit var repository: DishRepository

    @Test
//    @Transactional
    @DisplayName("update(): 3 селекта + 1 update, обновилось version")
    fun update() {
        //given
        val id = UUID.fromString("2f3cedce-ad2d-4782-98c6-c0f62b8a3f5c")
        val dish = repository.findById(id)
            .orElseThrow { IllegalStateException("Dish not found by id: $id") }
        val newName = "Мясо по-бразильски + ${Random.nextInt(10)}"
        dish?.name = newName
        //when
        repository.save(dish)
        //then
        repository.findById(id).also { assertEquals(newName, dish.name) }
    }
}