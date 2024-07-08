package dev.commerce.application.user

import dev.commerce.domain.entity.User

interface UserService {
    fun findById(userId: Long): User
}