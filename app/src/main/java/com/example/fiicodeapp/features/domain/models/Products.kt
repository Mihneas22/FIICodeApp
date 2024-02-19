package com.example.fiicodeapp.features.domain.models

data class Products(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)
