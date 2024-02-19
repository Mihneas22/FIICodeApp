package com.example.fiicodeapp.features.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fiicodeapp.features.data.repository.ProductRepository
import com.example.fiicodeapp.features.data.util.Resource
import com.example.fiicodeapp.features.domain.models.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productRepository: ProductRepository
): ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    private val _showErrorToastChannel = Channel<Boolean>()
    val showErrorToastChannel = _showErrorToastChannel.receiveAsFlow()

    init {
        viewModelScope.launch {
            productRepository.getProductList().collectLatest {result ->
                when(result){
                    is Resource.Failure -> {
                        _showErrorToastChannel.send(true)
                    }

                    is Resource.Succes ->{
                        result.result?.let { products->
                            _products.update { products }
                        }
                    }

                    is Resource.Loading ->{

                    }
                }

            }
        }
    }
}