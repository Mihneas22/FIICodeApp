package com.example.fiicodeapp.features.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fiicodeapp.features.presentation.components.HealthAppButton
import com.example.fiicodeapp.features.presentation.components.HealthAppTextField

@Preview
@Composable
fun SignUpScren(){
    Surface(modifier = Modifier.fillMaxSize(),
        color = Color(0xFF323232)
    ) {
        val username = remember{
            mutableStateOf("")
        }

        val password = remember{
            mutableStateOf("")
        }

        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {

            HealthAppTextField(text = username.value,
                onTextChange = {
                    if(it.all {char->
                        char.isLetterOrDigit()
                    })username.value=it
                }, label = "",
                color = Color(0xFF464646))

            HealthAppTextField(
                modifier = Modifier.padding(20.dp),
                text = password.value,
                onTextChange = {
                    if(it.all {char->
                            char.isLetterOrDigit()
                        })password.value=it
                }, label = "",
                color = Color(0xFF464646))

            HealthAppButton(text = "Save Data",
                onButClick = {
                             /*TODO*/
                             },
                color = Color(0xFF464646))
        }
    }
}