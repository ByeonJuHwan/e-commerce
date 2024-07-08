package dev.commerce.application.user

import dev.commerce.Exception.UserNotFoundException
import dev.commerce.application.user.repository.UserRepository
import dev.commerce.domain.entity.User
import org.springframework.stereotype.Service

@Service
class UserServiceImpl (
    private val userRepository : UserRepository
) : UserService {
    override fun findById(userId: Long): User {
        return userRepository.findById(userId) ?: throw UserNotFoundException("존재하지 않는 회원입니다")
    }
}