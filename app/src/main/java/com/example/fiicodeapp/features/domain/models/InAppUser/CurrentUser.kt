package com.example.fiicodeapp.features.domain.models.InAppUser

import com.example.fiicodeapp.features.domain.models.Allergens

data class CurrentUser(
    var id: String = "",
    var username: String = "",
    var password: String = "",
    var allergens: Allergens? = null
)