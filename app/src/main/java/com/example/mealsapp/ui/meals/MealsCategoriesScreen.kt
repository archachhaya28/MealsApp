package com.example.mealsapp.ui.meals

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.example.mealsapp.model.response.MealsResponse
import com.example.mealsapp.ui.theme.MealsAppTheme


/**
 * Created by Archa Chhaya on 26/8/2025
 */
@Composable
fun MealsCategoriesScreen(navigationCallBack: (String) -> Unit) {
    val viewModel: MealsCategoriesViewModel = viewModel()
    val meals = viewModel.mealsState.value

    // the code inside LaunchEffect will execute only once and not everytime when recomposition happens
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

    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        items(meals) { meals ->
            MealsCategory(meals, navigationCallBack)
        }
    }
}

@Composable
fun MealsCategory(meals: MealsResponse, navigationCallBack: (String) -> Unit) {
    var isExpanded by remember { mutableStateOf(false) }
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .clickable {
                navigationCallBack(meals.id)
            }
    ) {
        // Modifier.animateContentSize() is to display the smooth animation
        Row(modifier = Modifier.animateContentSize()) {
            AsyncImage(
                model = meals.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .align(Alignment.CenterVertically)

            )
            Column(modifier = Modifier
                .align(Alignment.CenterVertically)
                .fillMaxWidth(0.8f)
                .padding(16.dp)
            ) {
                Text(
                    text = meals.name,
                    style = MaterialTheme.typography.titleLarge
                )
                CompositionLocalProvider(value = LocalTextStyle provides LocalTextStyle.current) {
                    Text(
                        text = meals.description,
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.titleMedium,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = if (isExpanded) 10 else 4
                    )
                }
            }
            Icon(imageVector = if
                    (isExpanded) Icons.Filled.KeyboardArrowUp
                else
                    Icons.Filled.KeyboardArrowDown,
                contentDescription = "Expand row icon",
                modifier = Modifier
                    .padding(16.dp)
                    .align(if (isExpanded) Alignment.Bottom else Alignment.CenterVertically)
                    .clickable { isExpanded = !isExpanded }
                )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealsAppTheme {
      //  MealsCategoriesScreen()
    }
}