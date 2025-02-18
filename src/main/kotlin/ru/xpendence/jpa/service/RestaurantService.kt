package ru.xpendence.jpa.service

interface RestaurantService {

    fun getAllRestaurantNamesOrderedByAdmins(): List<String>
}