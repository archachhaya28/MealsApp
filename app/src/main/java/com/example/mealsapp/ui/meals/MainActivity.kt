package com.example.mealsapp.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mealsapp.model.response.MealsResponse
import com.example.mealsapp.ui.theme.MealsAppTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
    val rememberMeals = remember { mutableStateOf(emptyList<MealsResponse>()) }

    // the code inside LaunchEffect will execute only once and not everytime when recomposes
    // If the key changes, the code inside LaunchEffect will re-trigger
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(key1 = "GET_MEALS") {
        coroutineScope.launch(Dispatchers.IO) {
            val meals = viewModel.getMeals()
            rememberMeals.value = meals
        }
    }

    LazyColumn {
        items(rememberMeals.value) { meals ->
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