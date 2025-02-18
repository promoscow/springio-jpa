package ru.xpendence.jpa.service

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import ru.xpendence.jpa.JpaApplicationTests

class RestaurantServiceTest : JpaApplicationTests() {

    @Autowired
    private lateinit var service: RestaurantService

    @Test
    @DisplayName(" getAllRestaurantNamesOrderedByAdmins(): оцениваем оптимальность запроса")
    fun getAllRestaurantNamesOrderedByAdmins() {
        service.getAllRestaurantNamesOrderedByAdmins()
    }
}