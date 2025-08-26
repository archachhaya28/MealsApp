package com.example.mealsapp.model

import com.example.mealsapp.model.api.MealsWebService
import com.example.mealsapp.model.response.MealsCategoriesResponse

/**
* Created by Archa Chhaya on 25/8/2025
*/

class MealsRepository(private val webService: MealsWebService = MealsWebService()){
    suspend fun getMeals(): MealsCategoriesResponse {
        return webService.getMeals()
    }
}