package com.example.cleararch27feb.domain.repository

import com.example.cleararch27feb.domain.model.Food
import retrofit2.Response

interface FoodRepository {
    suspend fun getFood() :Response<Food>
}