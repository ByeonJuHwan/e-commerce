package dev.commerce.presentation.point.request

import dev.commerce.application.point.dto.ChargePointDto

data class ChargePointRequest (
    val userId : Long,
    val point : Long,
)

fun ChargePointRequest.toDto() = ChargePointDto(
    userId = userId,
    point = point,
)
