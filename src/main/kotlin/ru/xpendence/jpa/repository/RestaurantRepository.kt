package ru.xpendence.jpa.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.xpendence.jpa.domain.Restaurant
import java.util.UUID

interface RestaurantRepository : JpaRepository<Restaurant, UUID>