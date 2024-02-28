package com.example.fiicodeapp.features.presentation.screens.ProfileRelatedScreen

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material.icons.filled.Approval
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.PersonOutline
import androidx.compose.material.icons.filled.QuestionAnswer
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fiicodeapp.features.presentation.viewmodels.CreateUserViewModel

@Composable
fun ProfileScreen(
    createUserViewModel: CreateUserViewModel,
    navController: NavController
){
    val user = createUserViewModel.getUser.value

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

                Text(text = "Welcome!",
                    fontSize = 30.sp)

                Text(text = user.username,
                    fontSize = 30.sp)

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
                    .height(90.dp),
                ) {
                    Icon(imageVector = Icons.Default.PersonOutline,
                        contentDescription = "Icon",
                        modifier = Modifier.size(80.dp)
                    )

                    Text(text = "Manage your dietary preferences including allergens!",
                        fontSize = 20.sp,
                        modifier = Modifier
                            .clickable {
                                navController.navigate("DietaryPreferences")
                            }
                    )
                }

                //Food Preferences
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(top = 10.dp)
                ) {
                    Icon(imageVector = Icons.Default.Fastfood,
                        contentDescription = "Icon",
                        modifier = Modifier.size(70.dp).padding(start = 10.dp)
                    )

                    Text(text = "Manage your food preferences and your favorites dishes!",
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .clickable {

                            }
                    )
                }

                //Frequent Questions
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(top = 10.dp)
                ) {
                    Icon(imageVector = Icons.Default.QuestionAnswer,
                        contentDescription = "Icon",
                        modifier = Modifier.size(70.dp).padding(start = 10.dp)
                    )

                    Text(text = "Explore the most asked questions and some information about the app!",
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .clickable {

                            }
                    )
                }

                //Added Products
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(top = 10.dp)
                ) {
                    Icon(imageVector = Icons.Default.Approval,
                        contentDescription = "Icon",
                        modifier = Modifier.size(70.dp).padding(start = 10.dp)
                    )

                    Text(text = "Check for you added products!",
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .clickable {

                            }
                    )
                }

                //Connect with Us
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(top = 10.dp)
                ) {
                    Icon(imageVector = Icons.Default.Email,
                        contentDescription = "Icon",
                        modifier = Modifier.size(70.dp).padding(start = 10.dp)
                    )

                    Text(text = "If you need support, please contact us!",
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .clickable {

                            }
                    )
                }

            }

        }

    }
}