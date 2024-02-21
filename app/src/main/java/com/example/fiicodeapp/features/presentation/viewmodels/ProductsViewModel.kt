package com.example.fiicodeapp.features.presentation.viewmodels

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fiicodeapp.features.data.util.Resource
import com.example.fiicodeapp.features.domain.models_test.Product
import com.example.fiicodeapp.features.domain.repository.ProductRepositoryIMPL
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productRepo: ProductRepositoryIMPL
): ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products = _products.asStateFlow()

    private val _showErrorToastChannel = Channel<Boolean>()
    val showErrorToastChannel = _showErrorToastChannel.receiveAsFlow()

    init {
        viewModelScope.launch {
            productRepo.getProductsList().collectLatest { result->
                when(result){
                    is Resource.Failure ->{
                        _showErrorToastChannel.send(true)
                    }

                    is Resource.Succes ->{
                        result.result?.let { products->
                            _products.update { products }
                        }
                    }

                    is Resource.Loading ->{
                        Log.d("FB","Loading...")
                    }
                }
            }
        }
    }
}