package com.example.fiicodeapp.features.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fiicodeapp.features.data.repository.AuthRepository
import com.example.fiicodeapp.features.data.util.Resource
import com.example.fiicodeapp.features.domain.models.CurrentUser
import com.example.fiicodeapp.features.domain.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginInViewModel @Inject constructor(
    private val repository: AuthRepository
): ViewModel() {
    var loginInResponse by mutableStateOf<Resource<Boolean>>(Resource.Succes(false))
        private set

    private val _getUser = MutableStateFlow<CurrentUser>(CurrentUser())
    val getUser: MutableStateFlow<CurrentUser> = _getUser

    val getUsers: Flow<RealmList<User>>
        get() = repository.getUsers.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            realmListOf()
        )

    fun getCurrentUser(list: RealmList<User>, username: String)
            =viewModelScope.launch {
        val result = repository.getCurrentUser(list, username)
        getUser.value = result
    }

    fun loginInUser(list: RealmList<User>, username: String, password: String)
            =viewModelScope.launch {
        loginInResponse = Resource.Loading
        val result = repository.loginIn(list,username, password)
        loginInResponse = result
    }

}