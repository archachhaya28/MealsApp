package com.example.mealsapp.model.response

import com.google.gson.annotations.SerializedName

/**
 * Created by Archa Chhaya on 26/8/2025.
 * Email: mindsmatters@gmail.com
 */
data class MealsCategoriesResponse(private val categories: List<MealsResponse>)

data class MealsResponse(
    @SerializedName("idCategory") private val id: String,
    @SerializedName("strCategory") private val name: String,
    @SerializedName("strCategoryDescription") private val description: String,
    @SerializedName("strCategoryThumb") private val imageUrl: String
)