package com.example.fiicodeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fiicodeapp.features.presentation.screens.HomeScreen
import com.example.fiicodeapp.features.presentation.screens.LoginInScreen
import com.example.fiicodeapp.features.presentation.screens.SignUpScreen
import com.example.fiicodeapp.ui.theme.FIICodeAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
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