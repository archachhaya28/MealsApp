package com.example.mealsapp.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mealsapp.ui.theme.MealsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MealsAppTheme {
                MealsCategoriesScreen()
            }
        }
    }
}

@Composable
fun MealsCategoriesScreen() {
    val viewModel: MealsCategoriesViewModel = viewModel()
    val meals = viewModel.mealsState.value

    // the code inside LaunchEffect will execute only once and not everytime when recomposes
    // If the key changes, the code inside LaunchEffect will re-trigger
    // but this is not a good practice so we are commenting code
    // and instead hoist the state and coroutine in viewmodel

    /*val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(key1 = "GET_MEALS") {
        coroutineScope.launch(Dispatchers.IO) {
            val meals = viewModel.getMeals()
            rememberMeals.value = meals
        }
    }*/

    LazyColumn {
        items(meals) { meals ->
            Text(text = meals.name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MealsAppTheme {
        MealsCategoriesScreen()
    }
}