package com.example.mealsapp.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import coil3.compose.AsyncImage
import com.example.mealsapp.model.response.MealsResponse


/**
 * Created by Archa Chhaya on 27/8/2025
 */

@Composable
fun MealDetailsScreen(meal: MealsResponse?) {
    Column {
        Row {
            Card {
                AsyncImage(
                    model = meal?.imageUrl,
                    contentDescription = "Detail screen image",

                )
            }
            Text(meal?.name?: "default name")
        }
        Button(onClick = {/*TODO*/}) {

        }
    }
}