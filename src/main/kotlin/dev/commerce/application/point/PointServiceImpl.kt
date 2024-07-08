package dev.commerce.application.point

import dev.commerce.Exception.UserNotFoundException
import dev.commerce.application.point.dto.ChargePointDto
import dev.commerce.application.user.repository.UserRepository
import dev.commerce.domain.entity.Point
import dev.commerce.domain.entity.User
import dev.commerce.domain.repository.PointRepository
import org.springframework.stereotype.Service


@Service
class PointServiceImpl (
    private val pointRepository: PointRepository,
    private val userRepository: UserRepository,
) : PointService {

    override fun chargePoints(chargePointDto: ChargePointDto): ChargePointDto {
        val user = getUser(chargePointDto.userId)

        val point = getPoint(user)

        val chargedPoints = point.chargePoint(chargePointDto.point)
        pointRepository.save(chargedPoints)

        return ChargePointDto(userId = user.id, point = chargedPoints.point)
    }



    override fun getCurrentPoints(userId: Long): ChargePointDto {
        val user = getUser(userId)
        val currentPoints = getPoint(user)

        return ChargePointDto(userId = user.id, point = currentPoints.point)
    }

    private fun getUser(userId : Long) =
        userRepository.findById(userId) ?: throw UserNotFoundException("존재하지 않는 회원입니다")

    private fun getPoint(user: User) = pointRepository.findByUser(user) ?: Point(user, 0)
}
