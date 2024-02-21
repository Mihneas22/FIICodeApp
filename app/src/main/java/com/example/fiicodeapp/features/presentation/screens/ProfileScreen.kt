package com.example.fiicodeapp.features.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.example.fiicodeapp.features.presentation.viewmodels.CreateUserViewModel

@Composable
fun ProfileScreen(
    createUserViewModel: CreateUserViewModel
){
    val result = createUserViewModel.getUser.value

    Column(modifier = Modifier
        .fillMaxSize()) {

        //Header
        Card(modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
            shape = RectangleShape,
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF696262)
            ),
            border = BorderStroke(2.dp, Color.Black)
        ) {
            Column(modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {

                Text(text = "Welcome!")

            }
        }


        //Body
        Surface(modifier = Modifier
            .fillMaxWidth()
            .height(700.dp),
            color = Color(0xFF534C4C)
        ) {

            Column(modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp)) {


                //Account Managing
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                ) {

                }

                //Food Preferences
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(top = 10.dp)
                ) {

                }

                //Frequent Questions
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(top = 10.dp)
                ) {

                }

                //Connect with Us
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(top = 10.dp)
                ) {
                    
                }

            }

        }

    }
}