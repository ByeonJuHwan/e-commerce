package dev.commerce.presentation.point

import dev.commerce.ApiResult
import dev.commerce.application.point.PointFacade
import dev.commerce.presentation.point.request.ChargePointRequest
import dev.commerce.presentation.point.request.toDto
import dev.commerce.presentation.point.response.UsePointResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/points")
class PointController (
    private val pointFacade: PointFacade,
) {

    @PutMapping("/charge")
    fun chargePoint (
        @RequestBody chargePointRequest : ChargePointRequest
    ) : ApiResult<UsePointResponse> {
        return ApiResult(
            result = UsePointResponse.from(pointFacade.charge(chargePointRequest.toDto())),
            message = "포인트 충전 성공"
        )
    }

    @GetMapping("/{userId}")
    fun getMyPoint(
        @PathVariable userId: Long
    ) : ApiResult<UsePointResponse> {
        return ApiResult(
            result = UsePointResponse.from(pointFacade.getPoints(userId = userId)),
            message = "포인트 조회 성공"
        )
    }
}