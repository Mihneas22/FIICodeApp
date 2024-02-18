package com.example.fiicodeapp.features.domain.repository

import com.example.fiicodeapp.features.data.repository.AuthRepository
import com.example.fiicodeapp.features.data.util.Resource
import com.example.fiicodeapp.features.domain.models.User
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.ext.toRealmList
import io.realm.kotlin.types.RealmList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AuthRepositoryIMPL @Inject constructor(
    private val realm: Realm
): AuthRepository {

    override val getUsers: Flow<RealmList<User>>
        get() = realm.query<User>()
            .find()
            .asFlow()
            .map { results->
                results.list.toRealmList()
            }

    override suspend fun loginIn(email: String, password: String): Resource<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun signUp(email: String, password: String): Resource<Boolean> {
        TODO("Not yet implemented")
    }
}