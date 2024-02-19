package com.example.fiicodeapp.features.data.repository

import com.example.fiicodeapp.features.domain.models.Products
import retrofit2.http.GET

interface ApiRepository {

    @GET("product")
    suspend fun getFoods(): Products

    companion object{
        const val BASE_URL = "https://world.openfoodfacts.org/api/v2"
    }
}