package com.example.fiicodeapp.features.data.util

import com.example.fiicodeapp.R

sealed class Resource<out T> {
    data class Succes<out T>(val result: Boolean): Resource<Boolean>()
    data class Failure(val ex: Exception): Resource<Nothing>()
    data object Loading: Resource<Nothing>()
}