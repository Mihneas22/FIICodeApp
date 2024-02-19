package com.example.fiicodeapp.features.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NutrientLevel(
    private val fat: String? = null,
    private val salt: String? = null,
    @SerialName("saturated-fat")
    private val saturatedFat: String? = null,
    private val sugars: String? = null,
)