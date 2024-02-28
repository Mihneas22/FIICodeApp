package com.example.fiicodeapp.features.presentation.screens.Admin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun AdminScreen(

){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(
            color = Color(0xFF323232)
        )
        .padding(start = 20.dp, top = 20.dp)
        ,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
        ){

        Text(text = "New Added Products to Accept",
            fontSize = 20.sp)
    }
}

@Composable
fun Product(

){
    TODO()
}