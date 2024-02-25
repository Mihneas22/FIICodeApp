package com.example.fiicodeapp.features.presentation.screens.ProfileRelatedScreen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fiicodeapp.features.domain.models.Allergens
import com.example.fiicodeapp.features.domain.models.InAppUser.CurrentUser
import com.example.fiicodeapp.features.presentation.components.HealthAppButton
import com.example.fiicodeapp.features.presentation.viewmodels.CreateUserViewModel

@Composable
fun DietaryPreferences(
    createUserViewModel: CreateUserViewModel,
    navController: NavController,
){
    val radioOptionsMoluscs = listOf<Boolean>(true,false)
    var selectedOptionMoluscs by remember{
        mutableStateOf(radioOptionsMoluscs[0])
    }

    val radioOptionsEggs = listOf<Boolean>(true,false)
    var selectedOptionEggs by remember{
        mutableStateOf(radioOptionsMoluscs[0])
    }

    val radioOptionsFish = listOf<Boolean>(true,false)
    var selectedOptionFish by remember{
        mutableStateOf(radioOptionsMoluscs[0])
    }

    val radioOptionsLupin = listOf<Boolean>(true,false)
    var selectedOptionLupin by remember{
        mutableStateOf(radioOptionsMoluscs[0])
    }

    val radioOptionsSoya = listOf<Boolean>(true,false)
    var selectedOptionSoya by remember{
        mutableStateOf(radioOptionsMoluscs[0])
    }

    val radioOptionsMilk = listOf<Boolean>(true,false)
    var selectedOptionMilk by remember{
        mutableStateOf(radioOptionsMoluscs[0])
    }

    val radioOptionsPeanuts = listOf<Boolean>(true,false)
    var selectedOptionPeanuts by remember{
        mutableStateOf(radioOptionsMoluscs[0])
    }

    val radioOptionsGluten = listOf<Boolean>(true,false)
    var selectedOptionGluten by remember{
        mutableStateOf(radioOptionsMoluscs[0])
    }

    val radioOptionsCrustaceans = listOf<Boolean>(true,false)
    var selectedOptionCrustaceans by remember{
        mutableStateOf(radioOptionsMoluscs[0])
    }

    val radioOptionsNuts = listOf<Boolean>(true,false)
    var selectedOptionNuts by remember{
        mutableStateOf(radioOptionsMoluscs[0])
    }

    val radioOptionsMustard = listOf<Boolean>(true,false)
    var selectedOptionMustard by remember{
        mutableStateOf(radioOptionsMoluscs[0])
    }

    val radioOptionsSesame = listOf<Boolean>(true,false)
    var selectedOptionSesame by remember{
        mutableStateOf(radioOptionsMoluscs[0])
    }

    val radioOptionsCelery = listOf<Boolean>(true,false)
    var selectedOptionCelery by remember{
        mutableStateOf(radioOptionsMoluscs[0])
    }

    val radioOptionsSulphites = listOf<Boolean>(true,false)
    var selectedOptionSulphites by remember{
        mutableStateOf(radioOptionsMoluscs[0])
    }

    Surface(modifier = Modifier.fillMaxSize(),
        color = Color(0xFF323232)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding( start = 20.dp)
            .verticalScroll(rememberScrollState())
        ) {

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically) {

                Text(text = "Without Moluscs:",
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

            Row(modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically) {

                Text(text = "Without Eggs:",
                    fontSize = 15.sp,
                    color = Color.White,
                    modifier = Modifier.padding(end = 20.dp)
                )

                radioOptionsMoluscs.forEach {result->
                    Row {
                        RadioButton(selected = (result == selectedOptionEggs),
                            onClick = { selectedOptionEggs = result })
                    }
                }
                Text(text = "$selectedOptionEggs")
            }

            Row(modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically) {

                Text(text = "Without Fish:",
                    fontSize = 15.sp,
                    color = Color.White,
                    modifier = Modifier.padding(end = 20.dp)
                )

                radioOptionsMoluscs.forEach {result->
                    Row {
                        RadioButton(selected = (result == selectedOptionFish),
                            onClick = { selectedOptionFish = result })
                    }
                }
                Text(text = "$selectedOptionFish")
            }

            Row(modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically) {

                Text(text = "Without Lupin:",
                    fontSize = 15.sp,
                    color = Color.White,
                    modifier = Modifier.padding(end = 20.dp)
                )

                radioOptionsMoluscs.forEach {result->
                    Row {
                        RadioButton(selected = (result == selectedOptionLupin),
                            onClick = { selectedOptionLupin = result })
                    }
                }
                Text(text = "$selectedOptionLupin")
            }

            Row(modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically) {

                Text(text = "Without Soya:",
                    fontSize = 15.sp,
                    color = Color.White,
                    modifier = Modifier.padding(end = 20.dp)
                )

                radioOptionsMoluscs.forEach {result->
                    Row {
                        RadioButton(selected = (result == selectedOptionSoya),
                            onClick = { selectedOptionSoya = result })
                    }
                }
                Text(text = "$selectedOptionSoya")
            }

            Row(modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically) {

                Text(text = "Without Milk:",
                    fontSize = 15.sp,
                    color = Color.White,
                    modifier = Modifier.padding(end = 20.dp)
                )

                radioOptionsMoluscs.forEach {result->
                    Row {
                        RadioButton(selected = (result == selectedOptionMilk),
                            onClick = { selectedOptionMilk = result })
                    }
                }
                Text(text = "$selectedOptionMilk")
            }

            Row(modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically) {

                Text(text = "Without Peanuts:",
                    fontSize = 15.sp,
                    color = Color.White,
                    modifier = Modifier.padding(end = 20.dp)
                )

                radioOptionsMoluscs.forEach {result->
                    Row {
                        RadioButton(selected = (result == selectedOptionPeanuts),
                            onClick = { selectedOptionPeanuts = result })
                    }
                }
                Text(text = "$selectedOptionPeanuts")
            }

            Row(modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically) {

                Text(text = "Without Gluten:",
                    fontSize = 15.sp,
                    color = Color.White,
                    modifier = Modifier.padding(end = 20.dp)
                )

                radioOptionsMoluscs.forEach {result->
                    Row {
                        RadioButton(selected = (result == selectedOptionGluten),
                            onClick = { selectedOptionGluten = result })
                    }
                }
                Text(text = "$selectedOptionGluten")
            }

            Row(modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically) {

                Text(text = "Without Crustaceans:",
                    fontSize = 15.sp,
                    color = Color.White,
                    modifier = Modifier.padding(end = 20.dp)
                )

                radioOptionsMoluscs.forEach {result->
                    Row {
                        RadioButton(selected = (result == selectedOptionCrustaceans),
                            onClick = { selectedOptionCrustaceans = result })
                    }
                }
                Text(text = "$selectedOptionCrustaceans")
            }

            Row(modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically) {

                Text(text = "Without Mustard:",
                    fontSize = 15.sp,
                    color = Color.White,
                    modifier = Modifier.padding(end = 20.dp)
                )

                radioOptionsMoluscs.forEach {result->
                    Row {
                        RadioButton(selected = (result == selectedOptionMustard),
                            onClick = { selectedOptionMustard = result })
                    }
                }
                Text(text = "$selectedOptionMustard")
            }

            Row(modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically) {

                Text(text = "Without Nuts:",
                    fontSize = 15.sp,
                    color = Color.White,
                    modifier = Modifier.padding(end = 20.dp)
                )

                radioOptionsMoluscs.forEach {result->
                    Row {
                        RadioButton(selected = (result == selectedOptionNuts),
                            onClick = { selectedOptionNuts = result })
                    }
                }
                Text(text = "$selectedOptionNuts")
            }

            Row(modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically) {

                Text(text = "Without Sesame:",
                    fontSize = 15.sp,
                    color = Color.White,
                    modifier = Modifier.padding(end = 20.dp)
                )

                radioOptionsMoluscs.forEach {result->
                    Row {
                        RadioButton(selected = (result == selectedOptionSesame),
                            onClick = { selectedOptionSesame = result })
                    }
                }
                Text(text = "$selectedOptionSesame")
            }

            Row(modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically) {

                Text(text = "Without Celery:",
                    fontSize = 15.sp,
                    color = Color.White,
                    modifier = Modifier.padding(end = 20.dp)
                )

                radioOptionsMoluscs.forEach {result->
                    Row {
                        RadioButton(selected = (result == selectedOptionCelery),
                            onClick = { selectedOptionCelery = result })
                    }
                }
                Text(text = "$selectedOptionCelery")
            }

            Row(modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically) {

                Text(text = "Without Sulphites:",
                    fontSize = 15.sp,
                    color = Color.White,
                    modifier = Modifier.padding(end = 20.dp)
                )

                radioOptionsMoluscs.forEach {result->
                    Row {
                        RadioButton(selected = (result == selectedOptionSulphites),
                            onClick = { selectedOptionSulphites = result })
                    }
                }
                Text(text = "$selectedOptionSulphites")
            }



            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                HealthAppButton(text = "Save Changes",
                    onButClick = {
                        val name = createUserViewModel.getUser.value.username
                        val newUser = CurrentUser(
                            id = createUserViewModel.getUser.value.id,
                            username = createUserViewModel.getUser.value.username,
                            password = createUserViewModel.getUser.value.password,
                            allergens = Allergens().apply {
                                moluscs=selectedOptionMoluscs
                                eggs=selectedOptionEggs
                                fish=selectedOptionFish
                                lupin=selectedOptionLupin
                                soya=selectedOptionSoya
                                milk=selectedOptionMilk
                                peanuts=selectedOptionPeanuts
                                gluten=selectedOptionGluten
                                crustaceans=selectedOptionCrustaceans
                                mustard=selectedOptionMustard
                                nuts=selectedOptionNuts
                                sesame=selectedOptionSesame
                                celery=selectedOptionCelery
                                sulphites=selectedOptionSulphites
                            }
                        )
                        Log.d("DATA","${newUser.allergens?.eggs}")
                        createUserViewModel.updateDataAllergens(name,newUser)
                        navController.navigate("ProfileScreen")
                    },
                    color = Color(0xFF464646)
                )
            }
        }
    }
}