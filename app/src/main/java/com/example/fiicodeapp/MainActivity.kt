package com.example.fiicodeapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fiicodeapp.features.presentation.screens.AuthScreen.LoginInScreen
import com.example.fiicodeapp.features.presentation.screens.AuthScreen.SignUpScreen
import com.example.fiicodeapp.features.presentation.screens.HomeScreen
import com.example.fiicodeapp.features.presentation.screens.ProfileRelatedScreen.ProfileScreen
import com.example.fiicodeapp.features.presentation.viewmodels.CreateUserViewModel
import com.example.fiicodeapp.ui.theme.FIICodeAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FIICodeAppTheme {
                val sharedViewModel: CreateUserViewModel = viewModel()

                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "SignUpScreen"){
                    composable("SignUpScreen"){
                        SignUpScreen(navController = navController)
                    }

                    composable("HomeScreen"){
                        HomeScreen(navController = navController)
                    }
                    
                    composable("LoginInScreen"){
                        LoginInScreen(navController = navController, createUserViewModel = sharedViewModel)
                    }

                    composable("ProfileScreen"){
                        ProfileScreen(createUserViewModel = sharedViewModel)
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