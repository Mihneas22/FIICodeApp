package com.example.fiicodeapp.features.data.repository

import com.example.fiicodeapp.features.data.util.Resource
import com.example.fiicodeapp.features.domain.models.InAppUser.CurrentUser
import com.example.fiicodeapp.features.domain.models.User
import io.realm.kotlin.types.RealmList
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    val getUsers: Flow<RealmList<User>>
    suspend fun getCurrentUser(list: RealmList<User>, username: String): CurrentUser

    suspend fun loginIn(list: RealmList<User>,username: String, password: String): Resource<Boolean>

    suspend fun signUp(username: String,password: String): Resource<Boolean>

    suspend fun logOut(user: CurrentUser): CurrentUser
}