package dev.commerce.application.point

import dev.commerce.application.point.dto.ChargePointDto
import org.springframework.stereotype.Service

@Service
class PointFacade (
    private val pointService: PointService,
) {

    fun charge(chargePointDto: ChargePointDto) : ChargePointDto {
        return pointService.chargePoints(chargePointDto)
    }

    fun getPoints(userId: Long): ChargePointDto {
        return pointService.getCurrentPoints(userId)
    }

}