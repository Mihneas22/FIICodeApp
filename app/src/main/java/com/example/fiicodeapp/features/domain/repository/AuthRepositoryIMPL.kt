package com.example.fiicodeapp.features.domain.repository

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import com.example.fiicodeapp.features.data.repository.AuthRepository
import com.example.fiicodeapp.features.data.util.Resource
import com.example.fiicodeapp.features.domain.models.InAppUser.CurrentUser
import com.example.fiicodeapp.features.domain.models.User
import io.realm.kotlin.Realm
import io.realm.kotlin.UpdatePolicy
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

    override suspend fun getCurrentUser(list: RealmList<User>, username: String): CurrentUser {
        val user = CurrentUser()
        for (i in 0..<list.size) {
            if (list[i].username == username) {
                user.id = list[i]._id.toString()
                user.username = list[i].username
                user.password = list[i].password
                break
            }
        }
        return user
    }
    override suspend fun loginIn(list: RealmList<User>, username: String,password: String): Resource<Boolean>
    =try{
        val result = mutableStateOf(false)
        for (i in 0..<list.size)
        {
            if (username==list[i].username && password==list[i].password)
            {
                result.value=true
                break
            }
        }
        Resource.Succes(result.value)
    }catch (ex: Exception){
        Resource.Failure(ex)
    }

    override suspend fun signUp(username: String, password: String): Resource<Boolean>
    =try{
        realm.write {
            val user1 = User().apply {
                this.username = username
                this.password = password
            }
            copyToRealm(user1,UpdatePolicy.ALL)
        }
        Resource.Succes(true)
    }catch (ex: Exception){
        Resource.Failure(ex)
    }

    override suspend fun updateDataAllergens(username: String, user: CurrentUser): Resource<Boolean>
    =try{
        realm.write {
            var liveUser = query<User>("username == $username").find().first()
            Log.d("liveUser","dataBefore: ${liveUser.username}")
            liveUser = User().apply {
                this.allergens = user.allergens
                copyToRealm(liveUser,UpdatePolicy.ALL)
            }
            Log.d("liveUser","dataAfter: ${liveUser.username}")
            Resource.Succes(true)
        }
    }catch (ex: Exception){
        Resource.Failure(ex)
    }
    override suspend fun logOut(user: CurrentUser): CurrentUser {
        user.id=""
        user.username=""
        user.password=""

        return user
    }
}