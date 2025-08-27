package com.example.mealsapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mealsapp.ui.details.MealDetailsScreen
import com.example.mealsapp.ui.details.MealDetailsViewModel
import com.example.mealsapp.ui.meals.MealsCategoriesScreen
import com.example.mealsapp.ui.theme.MealsAppTheme

/**
 * Created by Archa Chhaya on 24/8/2025
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealsAppTheme {
                MealsApp()
            }
        }
    }
}

@Composable
// navigation graph
private fun MealsApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "destination_meals_list") {
        composable(route = "destination_meals_list") {
            MealsCategoriesScreen() { navigationMealsId ->
                navController.navigate("destination_meals_details/$navigationMealsId")
            }
        }
        composable(
            route = "destination_meals_details/{meal_category_id}",
            arguments = listOf(navArgument("meal_category_id") {
                type = NavType.StringType
            })
        ) {
            val viewModel: MealDetailsViewModel = viewModel()
            MealDetailsScreen(viewModel.mealState.value, navController)
        }
    }
}