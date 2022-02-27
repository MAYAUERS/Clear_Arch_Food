package com.example.cleararch27feb.data

import com.example.cleararch27feb.domain.model.Food
import com.example.cleararch27feb.domain.repository.FoodRepository
import retrofit2.Response

open class FoodRepositoryImpl: FoodRepository {
    override suspend fun getFood(): Response<Food> = getFood()
}