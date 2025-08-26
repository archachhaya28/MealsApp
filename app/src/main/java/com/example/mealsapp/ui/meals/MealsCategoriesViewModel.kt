package com.example.mealsapp.ui.meals

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealsapp.model.MealsRepository
import com.example.mealsapp.model.response.MealsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()): ViewModel() {

    init {
        Log.d("TAG_COROUTINES", "we are about to launch a coroutine") // 1
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("TAG_COROUTINES", "we have launched a coroutine") // 3
            val meals = getMeals()
            Log.d("TAG_COROUTINES", "we have received the async data") // 4
            mealsState.value = meals
        }
        Log.d("TAG_COROUTINES", "other work") // 2
    }

    val mealsState = mutableStateOf(emptyList<MealsResponse>())

    private suspend fun getMeals(): List<MealsResponse> {
        return repository.getMeals().categories
    }
}