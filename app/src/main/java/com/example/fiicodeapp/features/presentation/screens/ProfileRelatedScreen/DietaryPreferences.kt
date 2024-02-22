package com.example.fiicodeapp.features.presentation.screens.ProfileRelatedScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun DietaryPreferences(

){
    val radioOptionsMoluscs = listOf<Boolean>(true,false)
    var selectedOptionMoluscs by remember{
        mutableStateOf(radioOptionsMoluscs[0])
    }

    Surface(modifier = Modifier.fillMaxSize(),
        color = Color(0xFF323232)
    ) {
        Column(modifier = Modifier.fillMaxSize().padding(20.dp)) {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically) {

                Text(text = "Without Gluten:",
                    fontSize = 15.sp,
                    color = Color.White,
                    modifier = Modifier.padding(end = 20.dp)
                )

                radioOptionsMoluscs.forEach {result->
                    Row {
                        RadioButton(selected = (result == selectedOptionMoluscs),
                            onClick = { selectedOptionMoluscs = result })
                    }
                }
                
                Text(text = "$selectedOptionMoluscs")
            }
        }
    }
}