package com.example.fiicodeapp.features.data.repository

import com.example.fiicodeapp.features.data.util.Resource
import com.example.fiicodeapp.features.domain.models.User
import io.realm.kotlin.types.RealmList
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    val getUsers: Flow<RealmList<User>>

    suspend fun loginIn(email: String, password: String): Resource<Boolean>

    suspend fun signUp(email: String,password: String): Resource<Boolean>
}