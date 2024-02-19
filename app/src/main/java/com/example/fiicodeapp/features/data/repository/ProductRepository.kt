package com.example.fiicodeapp.features.data.repository

import com.example.fiicodeapp.features.data.util.Resource
import com.example.fiicodeapp.features.domain.models.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun getProductList(): Flow<Resource<List<Product>>>
}