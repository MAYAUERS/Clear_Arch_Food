package com.example.cleararch27feb.domain.useCase

import com.example.cleararch27feb.domain.model.Food
import com.example.cleararch27feb.domain.repository.FoodRepository
import retrofit2.Response

class FoodUseCase(private val foodRepository: FoodRepository) {

    suspend operator fun invoke() : Response<Food> =foodRepository.getFood()
}