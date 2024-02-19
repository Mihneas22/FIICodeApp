package com.example.fiicodeapp.features.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.fiicodeapp.features.domain.models.Product
import com.example.fiicodeapp.features.presentation.viewmodels.ProductsViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun ProductsScreen(
    productsViewModel: ProductsViewModel = hiltViewModel()
){
    val productList = productsViewModel.products.collectAsState().value

    val context = LocalContext.current
    LaunchedEffect(key1 = productsViewModel.showErrorToastChannel){
        productsViewModel.showErrorToastChannel.collectLatest { show->
            if(show){
                Toast.makeText(context,"Error",Toast.LENGTH_SHORT).show()
            }
        }
    }

    if(productList.isEmpty()){

    }else{
        LazyColumn(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(16.dp)){
            items(productList.size){index ->
                ProductIt(productList[index])
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun ProductIt(product: Product) {
    val ingredient = product.ingredients[0]

    Column(modifier = Modifier
        .height(300.dp)
        .fillMaxWidth()) {
        Text(text = ingredient.toString())
    }
}
