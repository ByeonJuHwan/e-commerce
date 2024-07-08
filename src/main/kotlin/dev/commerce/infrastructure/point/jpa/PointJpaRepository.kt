package dev.commerce.infrastructure.point.jpa

import dev.commerce.domain.entity.Point
import dev.commerce.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface PointJpaRepository :JpaRepository<Point, Long> {

    fun findByUser(user: User): Point?
}