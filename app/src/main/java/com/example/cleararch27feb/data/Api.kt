package com.example.cleararch27feb.data

import com.example.cleararch27feb.domain.model.Food
import retrofit2.Response
import retrofit2.http.GET

interface Api {


    //https://api.fda.gov/food/enforcement.json?limit=10
    @GET("food/enforcement.json?limit=10")
    suspend fun getFood() :Response<Food>
}