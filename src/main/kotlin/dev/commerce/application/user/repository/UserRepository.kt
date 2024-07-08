package dev.commerce.application.user.repository

import dev.commerce.domain.entity.User

interface UserRepository {
    fun findById(userId: Long): User?
}