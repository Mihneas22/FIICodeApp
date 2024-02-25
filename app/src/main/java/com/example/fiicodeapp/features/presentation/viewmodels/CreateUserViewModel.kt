package com.example.fiicodeapp.features.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fiicodeapp.features.data.repository.AuthRepository
import com.example.fiicodeapp.features.domain.models.InAppUser.CurrentUser
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
class CreateUserViewModel @Inject constructor(
    private val repository: AuthRepository
): ViewModel() {

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

    fun updateDataAllergens(username: String, user: CurrentUser)
    =viewModelScope.launch{
        repository.updateDataAllergens(username,user)
    }

    fun logOut(user: CurrentUser)
    =viewModelScope.launch{
        getUser.value = repository.logOut(getUser.value)
    }
}