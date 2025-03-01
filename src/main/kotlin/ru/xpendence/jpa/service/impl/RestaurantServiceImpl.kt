package ru.xpendence.jpa.service.impl

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.xpendence.jpa.domain.type.RoleType
import ru.xpendence.jpa.repository.RestaurantRepository
import ru.xpendence.jpa.service.RestaurantService

@Service
class RestaurantServiceImpl(
    private val repository: RestaurantRepository
) : RestaurantService {

    @Transactional
    override fun getAllRestaurantNamesOrderedByAdmins(): List<String> =
        repository
            .findAll()
            .filter { restaurant ->
                restaurant
                    .dishes
                    .flatMap { it.orders }
                    .map { it.user }
                    .flatMap { it!!.roles }
                    .any { it.name == RoleType.ADMIN }
            }
            .sortedBy { it.name }
            .map { it!!.name!! }
}