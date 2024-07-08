package dev.commerce.application.user.dto

import dev.commerce.domain.entity.User

data class UserResponseDto(
    val userId : Long,
) {
    companion object {
        fun from(user: User) = UserResponseDto(
            userId = user.id,
        )
    }
}

