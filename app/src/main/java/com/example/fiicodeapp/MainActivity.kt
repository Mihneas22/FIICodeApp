package com.example.fiicodeapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fiicodeapp.di.AppModule
import com.example.fiicodeapp.features.domain.repository.ProductRepositoryIMPL
import com.example.fiicodeapp.features.presentation.screens.HomeScreen
import com.example.fiicodeapp.features.presentation.screens.LoginInScreen
import com.example.fiicodeapp.features.presentation.screens.MainScreen
import com.example.fiicodeapp.features.presentation.screens.SignUpScreen
import com.example.fiicodeapp.features.presentation.viewmodels.ProductsViewModel
import com.example.fiicodeapp.ui.theme.FIICodeAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<ProductsViewModel>(factoryProducer = {
        object : ViewModelProvider.Factory {
            @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ProductsViewModel(ProductRepositoryIMPL(AppModule.api))
                        as T
            }
        }
    })
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FIICodeAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "SignUpScreen"){
                    composable("SignUpScreen"){
                        SignUpScreen(navController = navController)
                    }

                    composable("HomeScreen"){
                        HomeScreen()
                    }
                    
                    composable("LoginInScreen"){
                        LoginInScreen(navController = navController)
                    }

                    composable("ProductsScreen"){
                        MainScreen(productsViewModel = viewModel)
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FIICodeAppTheme {

    }
}