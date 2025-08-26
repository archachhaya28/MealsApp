package com.example.mealsapp.model.api

import com.example.mealsapp.model.response.MealsCategoriesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


/**
 * Created by Archa Chhaya on 26/8/2025
 */

// this class should returns the actual retrofit response for our request

class MealsWebService {
    private var api: MealsApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MealsApi::class.java)

    }
    // we need to wrap the response in the Call object.
    // Call object allow you to wait for the response which is synchronous task
    // It Call return errors or some additional data as well

    suspend fun getMeals(): MealsCategoriesResponse {
        return api.getMeals()
    }

    interface MealsApi {
        @GET("categories.php")
        suspend fun getMeals(): MealsCategoriesResponse
    }
}