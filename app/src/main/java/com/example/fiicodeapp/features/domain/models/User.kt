package com.example.fiicodeapp.features.domain.models

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class User: RealmObject {
    @PrimaryKey var _id: ObjectId = ObjectId()
    var username: String = ""
    var password: String = ""
    var allergens: Allergens? = null
}