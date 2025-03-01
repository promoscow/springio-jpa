package ru.xpendence.jpa.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.xpendence.jpa.domain.Dish
import java.util.UUID

interface DishRepository : JpaRepository<Dish, UUID> {


    fun findDishByName(name: String): Dish
}