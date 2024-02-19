package com.example.fiicodeapp.features.domain.models

import kotlinx.serialization.Serializable

@Serializable
class SelectedImage {
    val display: SelectedImageItem? = null
    val small: SelectedImageItem? = null
    val thumb: SelectedImageItem? = null
}