package dev.commerce.infrastructure.point

import dev.commerce.domain.repository.PointRepository
import dev.commerce.domain.entity.Point
import dev.commerce.domain.entity.User
import dev.commerce.infrastructure.point.jpa.PointJpaRepository
import org.springframework.stereotype.Repository

@Repository
class PointJpaRepositoryImpl (
    private val pointJpaRepository: PointJpaRepository,
) : PointRepository {

    override fun findByUser(user: User): Point? {
        return pointJpaRepository.findByUser(user)
    }

    override fun save(point: Point): Point {
        return pointJpaRepository.save(point)
    }
}