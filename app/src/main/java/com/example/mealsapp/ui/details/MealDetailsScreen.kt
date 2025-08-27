package com.example.mealsapp.ui.details

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.example.mealsapp.model.response.MealsResponse


/**
 * Created by Archa Chhaya on 27/8/2025
 */

@Composable
fun MealDetailsScreen(meal: MealsResponse?, navController: NavHostController) {
    val scrollState: ScrollState = rememberScrollState()
    Scaffold(topBar = {
        AppBar(
            title = "Meal details",
            icon = Icons.Default.Close
        ) {
            navController.navigateUp()
        }
    }) { padding ->
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.padding(top = 150.dp)
        ) {
            Column {
                Surface(shadowElevation = 4.dp) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Card(modifier = Modifier.padding(16.dp),
                            shape = CircleShape,
                            border = BorderStroke(
                                width = 8.dp,
                                color = Color.Magenta
                            )
                        ) {
                            AsyncImage(
                                model = meal?.imageUrl,
                                contentDescription = "Detail screen image",
                                modifier = Modifier
                                    .size(200.dp)
                                    .padding(8.dp)
                            )
                        }
                        Text(
                            text = meal?.name?: "default name",
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier
                                .padding(16.dp)
                                .align(Alignment.CenterVertically)
                        )
                    }
                }
                Column(modifier = Modifier.verticalScroll(scrollState)) {
                    Text(
                        text = meal?.description?: "",
                        modifier = Modifier.padding(32.dp),
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(title: String, icon: ImageVector, iconClickAction: () -> Unit) {
    TopAppBar(
        navigationIcon = {
            Icon(
                icon,
                contentDescription = "",
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .clickable(onClick = { iconClickAction.invoke() })
            )
        },
        title = { Text(title) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Gray,
            titleContentColor = Color.White
        )

    )
}