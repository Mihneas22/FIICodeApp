package com.example.fiicodeapp.features.presentation.screens

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.fiicodeapp.features.presentation.viewmodels.ProductsViewModel

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun MainScreen(
    productsViewModel: ProductsViewModel
){
    val productsList = productsViewModel.products.collectAsState().value
    Surface(modifier = Modifier.fillMaxSize()) {
        Text(text = productsList.size.toString())
    }
}