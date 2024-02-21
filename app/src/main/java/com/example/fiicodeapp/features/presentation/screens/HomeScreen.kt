package com.example.fiicodeapp.features.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ListAlt
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(
    navController: NavController
){
    Column(modifier = Modifier.fillMaxSize()) {
        Surface(modifier = Modifier
            .fillMaxWidth()
            .height(800.dp),
            color = Color(0xFF323232)
        ) {

        }

        Surface(modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
            color = Color(0xFF534C4C)
        ) {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {

                Icon(imageVector = Icons.Rounded.Person,
                    contentDescription = "Icon Profile",
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .size(50.dp)
                        .clickable {
                            navController.navigate("ProfileScreen")
                        }
                )


                Icon(imageVector = Icons.Rounded.Search,
                    contentDescription = "Icon Search",
                    modifier = Modifier
                        .size(50.dp)
                        .clickable {
                            TODO()
                        }
                )

                Icon(imageVector = Icons.Rounded.ListAlt,
                    contentDescription = "Icon Profile",
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(50.dp)
                        .clickable {
                            TODO()
                        }
                )
            }
        }
    }
}