package dev.commerce.infrastructure.user

import dev.commerce.application.user.repository.UserRepository
import dev.commerce.domain.entity.User
import dev.commerce.infrastructure.user.jpa.UserJpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class UserJpaRepositoryImpl (
    private val userJpaRepository: UserJpaRepository
): UserRepository {
    override fun findById(userId: Long): User? {
        return userJpaRepository.findByIdOrNull(userId)
    }
}