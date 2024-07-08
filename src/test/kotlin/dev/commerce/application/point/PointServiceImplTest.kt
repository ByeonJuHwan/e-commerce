package dev.commerce.application.point

import dev.commerce.application.point.dto.ChargePointDto
import dev.commerce.application.user.repository.UserRepository
import dev.commerce.domain.repository.PointRepository
import dev.commerce.domain.entity.User
import dev.commerce.domain.entity.Point
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class PointServiceImplTest {

    @Mock
    lateinit var pointRepository: PointRepository

    @Mock
    lateinit var userRepository: UserRepository

    @InjectMocks
    lateinit var pointService: PointServiceImpl

    @Test
    fun `포인트 정보가 없는 회원이 포인트를 1000 포인트 충전하면 1000 포인트가 된다`() {
        val userId = 1L
        val amount = 1000L
        val user = User()
        val point = Point(user,0)

        // when
        `when`(userRepository.findById(userId)).thenReturn(user)
        `when`(pointRepository.findByUser(user)).thenReturn(point)
        val chargePoints = pointService.chargePoints(ChargePointDto(userId, amount))

        // then
        assertThat(chargePoints.point).isEqualTo(1000L)
    }
    @Test
    fun `포인트가 500포인트를 소지한 회원이  1000 포인트 충전하면 1500 포인트가 된다`() {
        val userId = 1L
        val amount = 1000L
        val user = User()
        val point = Point(user,500)

        // when
        `when`(userRepository.findById(userId)).thenReturn(user)
        `when`(pointRepository.findByUser(user)).thenReturn(point)
        val chargePoints = pointService.chargePoints(ChargePointDto(userId, amount))

        // then
        assertThat(chargePoints.point).isEqualTo(1500)
    }


    @Test
    fun `포인트가 음수이면 예외를 던진다`() {
        val userId = 1L
        val amount = -1000L
        val user = User()
        val point = Point(user,500)

        // when
        `when`(userRepository.findById(userId)).thenReturn(user)
        `when`(pointRepository.findByUser(user)).thenReturn(point)

        // then
        assertThatThrownBy {
            pointService.chargePoints(ChargePointDto(userId, amount))
        }.isInstanceOf(IllegalArgumentException::class.java)

    }

    @Test
    fun `userId 로 현재 포인트를 조회하면 현재 포인트가 조회된다`() {
        val userId = 1L
        val user = User()
        val point = Point(user,500)

        // when
        `when`(userRepository.findById(userId)).thenReturn(user)
        `when`(pointRepository.findByUser(user)).thenReturn(point)
        val currentPoints = pointService.getCurrentPoints(userId)

        assertThat(currentPoints.point).isEqualTo(500)
    }

    @Test
    fun `포인트 정보가 없는 회원이 현재 포인트를 조회하면 0 포인트가 조회된다`() {
        val userId = 1L
        val user = User()

        // when
        `when`(userRepository.findById(userId)).thenReturn(user)
        `when`(pointRepository.findByUser(user)).thenReturn(null)
        val currentPoints = pointService.getCurrentPoints(userId)

        assertThat(currentPoints.point).isEqualTo(0)
    }
}