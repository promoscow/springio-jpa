package ru.xpendence.jpa.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.xpendence.jpa.domain.User
import java.util.UUID

interface UserRepository : JpaRepository<User, UUID> {

    fun getUserById(id: UUID): User
}