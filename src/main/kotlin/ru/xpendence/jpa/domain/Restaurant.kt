package ru.xpendence.jpa.domain

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "restaurants")
class Restaurant(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: UUID? = null,

    @Column(name = "name")
    var name: String? = null,

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true)
    val dishes: List<Dish> = listOf()
) {

    companion object {

        fun enrichForUpdate(forUpdate: Restaurant, stored: Restaurant) {
            stored.name = forUpdate.name
        }
    }
}
