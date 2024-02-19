package com.example.fiicodeapp.features.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fiicodeapp.features.data.repository.AuthRepository
import com.example.fiicodeapp.features.data.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val repository: AuthRepository
): ViewModel() {
    var signUpResponse by mutableStateOf<Resource<Boolean>>(Resource.Succes(false))
        private set

    fun createUser(username: String,password: String)
            =viewModelScope.launch{
        signUpResponse=Resource.Loading
        repository.signUp(username, password)
    }
}