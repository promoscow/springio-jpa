package ru.xpendence.jpa.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.xpendence.jpa.domain.Role
import java.util.UUID

interface RoleRepository : JpaRepository<Role, UUID>