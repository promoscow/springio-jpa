package ru.xpendence.jpa.service

import ru.xpendence.jpa.domain.Dish
import java.util.UUID

interface DishService {

    fun get(id: UUID): Dish
}