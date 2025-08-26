package com.example.mealsapp.ui.meals

import androidx.lifecycle.ViewModel
import com.example.mealsapp.model.MealsRepository
import com.example.mealsapp.model.response.MealsResponse

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()): ViewModel() {

    suspend fun getMeals(): List<MealsResponse> {
        return repository.getMeals().categories
    }
}