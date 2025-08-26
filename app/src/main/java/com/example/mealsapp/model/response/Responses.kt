package com.example.mealsapp.model.response

import com.google.gson.annotations.SerializedName

/**
 * Created by Archa Chhaya on 26/8/2025
 */
data class MealsCategoriesResponse(val categories: List<MealsResponse>)

data class MealsResponse(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val name: String,
    @SerializedName("strCategoryDescription") val description: String,
    @SerializedName("strCategoryThumb") val imageUrl: String
)