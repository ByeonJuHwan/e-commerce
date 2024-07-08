package dev.commerce.application.point

import dev.commerce.application.point.dto.ChargePointDto

interface PointService {

    fun chargePoints(chargePointDto: ChargePointDto) : ChargePointDto
    fun getCurrentPoints(userId: Long): ChargePointDto
}