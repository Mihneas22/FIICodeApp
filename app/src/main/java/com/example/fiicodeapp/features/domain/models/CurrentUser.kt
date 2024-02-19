package com.example.fiicodeapp.features.domain.models

data class CurrentUser(
    var id: String = "",
    var email: String = "",
    var password: String = "",
    var code: String = "",
)