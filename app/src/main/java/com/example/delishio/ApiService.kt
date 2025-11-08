package com.example.delishio

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("search.php?f=c")
    fun getMeals(): Call<MealResponse>
}