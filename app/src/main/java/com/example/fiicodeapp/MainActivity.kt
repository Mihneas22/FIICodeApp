package com.example.fiicodeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.fiicodeapp.features.presentation.screens.SignUpScren
import com.example.fiicodeapp.ui.theme.FIICodeAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FIICodeAppTheme {
                SignUpScren()
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