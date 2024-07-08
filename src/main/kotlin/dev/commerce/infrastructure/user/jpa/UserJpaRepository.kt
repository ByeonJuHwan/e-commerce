package dev.commerce.infrastructure.user.jpa

import dev.commerce.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository : JpaRepository<User, Long> {
}