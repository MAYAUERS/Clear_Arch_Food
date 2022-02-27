package com.example.cleararch27feb.data

import com.example.cleararch27feb.domain.model.Food
import retrofit2.Response

class FoodDataSourse(private val api: Api): FoodRepositoryImpl(){
    override suspend fun getFood(): Response<Food> = api.getFood()
}