package ru.xpendence.jpa.service.impl

import org.springframework.stereotype.Service
import ru.xpendence.jpa.domain.Dish
import ru.xpendence.jpa.repository.DishRepository
import ru.xpendence.jpa.service.DishService
import java.util.UUID

@Service
class DishServiceImpl(
    private val repository: DishRepository
) : DishService {

    override fun get(id: UUID): Dish =
        repository.findById(id).orElseThrow { IllegalStateException("Dish not found by id: $id") }
}