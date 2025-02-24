package ru.xpendence.jpa.domain

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import jakarta.persistence.Version
import java.math.BigDecimal
import java.util.UUID

@Entity
@Table(name = "dishes")
class Dish(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: UUID? = null,

    @Column(name = "name")
    var name: String? = null,

    @Column(name = "price")
    var price: BigDecimal? = null,

    @Column(name = "active")
    var active: Boolean? = null,

    @Version
    var version: Int? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    val restaurant: Restaurant? = null,

    @OneToMany(mappedBy = "dish", fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true)
    val orders: List<Order> = listOf()
) {

    companion object {

        fun enrichForUpdate(forUpdate: Dish, stored: Dish) {
            stored.name = forUpdate.name
            stored.price = forUpdate.price
            stored.active = forUpdate.active
        }
    }
}
