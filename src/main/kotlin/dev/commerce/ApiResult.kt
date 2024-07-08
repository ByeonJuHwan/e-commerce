package dev.commerce

data class ApiResult<T>(
    val message : String,
    val result: T?,
)