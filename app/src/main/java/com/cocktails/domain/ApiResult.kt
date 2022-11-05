package com.cocktails.domain

sealed class ApiResult<out T> {

    object Loading: ApiResult<Nothing>()

    data class Success<out T>(val result: T): ApiResult<T>()

    data class Error(val e: Exception) {
        val message get() = e.message
    }
}
