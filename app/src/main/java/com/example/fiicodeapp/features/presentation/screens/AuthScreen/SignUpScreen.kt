package com.example.fiicodeapp.features.presentation.screens.AuthScreen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.fiicodeapp.R
import com.example.fiicodeapp.features.presentation.components.HealthAppButton
import com.example.fiicodeapp.features.presentation.components.HealthAppTextField
import com.example.fiicodeapp.features.presentation.viewmodels.CreateUserViewModel
import com.example.fiicodeapp.features.presentation.viewmodels.SignUpViewModel
import io.realm.kotlin.ext.realmListOf

@Composable
fun SignUpScreen(
    signUpViewModel: SignUpViewModel = hiltViewModel(),
    createUserViewModel: CreateUserViewModel,
    navController: NavController
){
    Surface(modifier = Modifier.fillMaxSize(),
        color = Color(0xFF323232)
    ) {
        val username = remember{
            mutableStateOf("")
        }

        val password = remember{
            mutableStateOf("")
        }

        val list by createUserViewModel.getUsers.collectAsState(initial = realmListOf())

        val context = LocalContext.current

        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {


            Image(painter = painterResource(id = R.drawable.iconfood),
                contentDescription = "Icon",
                modifier = Modifier
                    .height(120.dp)
                    .width(120.dp)
            )

            Text(text = "Welcome to NutriWiz!",
                modifier = Modifier.padding(top = 10.dp, bottom = 100.dp),
                fontSize = 30.sp,
                color = Color(0xFFE4E4E4)
            )

            Text(text = "Create your account!!",
                modifier = Modifier.padding(bottom = 70.dp),
                fontSize = 30.sp,
                color = Color(0xFFE4E4E4)
            )

            Text(text = "Enter Your Username:",
                color = Color(0xFFE4E4E4)
            )

            HealthAppTextField(
                modifier = Modifier.padding(top = 5.dp),
                text = username.value,
                onTextChange = {
                    if(it.all {char->
                        char.isLetterOrDigit()
                    })username.value=it
                }, label = "",
                color = Color(0xFF464646))

            Text(text = "Enter Your Password:",
                modifier = Modifier.padding(top = 30.dp),
                color = Color(0xFFE4E4E4)
            )

            HealthAppTextField(
                modifier = Modifier.padding(top = 5.dp),
                text = password.value,
                onTextChange = {
                    if(it.all {char->
                            char.isDefined()
                        })password.value=it
                }, label = "",
                color = Color(0xFF464646))

            Text(text = "Please enter an 8 character password.",
                modifier = Modifier.padding(top = 5.dp,bottom = 13.dp),
                color = Color(0xFFE4E4E4)
            )

            HealthAppButton(text = "Sign Up",
                onButClick = {
                    if(username.value.isEmpty() || password.value.isEmpty()){
                        Toast.makeText(context,"Please enter a username and a password!",Toast.LENGTH_SHORT).show()
                    }
                    else if(password.value.length<8){
                        Toast.makeText(context,"Please enter a valid password!",Toast.LENGTH_SHORT).show()
                    }
                    else{
                        signUpViewModel.createUser(username.value,password.value)
                        createUserViewModel.getCurrentUser(list,username.value) //E
                        navController.navigate("HomeScreen")
                    }
                             },
                color = Color(0xFF464646))

            Text(text = "Already have an account?",
                fontSize = 15.sp,
                modifier = Modifier
                    .clickable {
                        navController.navigate("LoginInScreen")
                    }
                    .padding(top = 15.dp),
                color = Color(0xFFE4E4E4)
            )
        }
    }
}