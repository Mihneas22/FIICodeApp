package com.example.fiicodeapp.features.presentation.screens.ProfileRelatedScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fiicodeapp.features.presentation.components.HealthAppButton

@Preview
@Composable
fun AddedProductsSubmissionScreen(

){
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(40.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        HealthAppButton(text = "+",
            onButClick = {
                         /*TODO*/
                         },
            color = Color(0xFF3557AD)
        )
    }
}