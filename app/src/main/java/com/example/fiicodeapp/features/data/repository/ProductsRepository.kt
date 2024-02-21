package com.example.fiicodeapp.features.data.repository

import com.example.fiicodeapp.features.data.util.Resource
import com.example.fiicodeapp.features.domain.models_test.Product
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

    suspend fun getProductsList(): Flow<Resource<List<Product>>>
}