package dev.commerce.presentation.point.response

import dev.commerce.application.point.dto.ChargePointDto

data class UsePointResponse(
    val currentPoint : Long,
) {
    companion object {
        fun from(chargePointDto: ChargePointDto ) : UsePointResponse {
            return UsePointResponse(
                currentPoint = chargePointDto.point
            )
        }
    }
}
