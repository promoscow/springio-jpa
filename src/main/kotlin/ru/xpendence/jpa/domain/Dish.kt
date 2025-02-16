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
import jakarta.persistence.Table
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

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.MERGE])
    @JoinColumn(name = "restaurant_id", nullable = false)
    val restaurant: Restaurant? = null
) {

    companion object {

        fun enrichForUpdate(forUpdate: Dish, stored: Dish) {
            stored.name = forUpdate.name
            stored.price = forUpdate.price
            stored.active = forUpdate.active
        }
    }
}
