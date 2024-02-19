package com.example.fiicodeapp.features.data.util

sealed class Resource<out T> {
    data class Succes<out T>(val result: T): Resource<Boolean>()
    data class Failure(val ex: Exception): Resource<Nothing>()
    data object Loading: Resource<Nothing>()
}