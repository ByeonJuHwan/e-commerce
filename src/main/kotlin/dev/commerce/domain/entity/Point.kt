package dev.commerce.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class Point (
    user : User,
    point : Long
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: User = user
        private set

    @Column(nullable = false)
    var point: Long = point
        protected set

    fun chargePoint(amount : Long) : Point {
        if(amount <= 0) {
            throw NumberFormatException("amount must be greater than zero")
        }
        point += amount

        return this
    }
}