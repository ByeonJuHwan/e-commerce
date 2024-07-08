package dev.commerce.domain.repository

import dev.commerce.domain.entity.Point
import dev.commerce.domain.entity.User

interface PointRepository {
    fun findByUser(user: User): Point?
    fun save(point: Point): Point
}