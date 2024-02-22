package com.example.fiicodeapp.features.domain.models

import io.realm.kotlin.types.EmbeddedRealmObject

class Allergens: EmbeddedRealmObject {
    var moluscs: Boolean = false
    var eggs: Boolean = false
    var fish: Boolean = false
    var lupin: Boolean = false
    var soya: Boolean = false
    var milk: Boolean = false
    var peanuts: Boolean = false
    var gluten: Boolean = false
    var crustaceans: Boolean = false
    var mustard: Boolean = false
    var nuts: Boolean = false
    var sesame: Boolean = false
    var celery: Boolean = false
    var sulphites: Boolean = false

    var user: User? = null
}