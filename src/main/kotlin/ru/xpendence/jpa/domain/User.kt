package ru.xpendence.jpa.domain

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "users")
class User(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: UUID? = null,

    @Column(name = "username", unique = true)
    val username: String? = null,

    @Column(name = "password")
    var password: String? = null,

    @ManyToMany(cascade = [CascadeType.DETACH], fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_roles",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    val roles: Set<Role> = setOf()
) {

    companion object {

        fun enrichForUpdate(forUpdate: User, stored: User) {
            stored.password = forUpdate.password
        }
    }
}
