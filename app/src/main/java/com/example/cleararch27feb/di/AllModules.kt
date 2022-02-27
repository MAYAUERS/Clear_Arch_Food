package com.example.cleararch27feb.di

import com.example.cleararch27feb.data.FoodDataSourse
import com.example.cleararch27feb.domain.repository.FoodRepository
import com.example.cleararch27feb.domain.useCase.FoodUseCase
import com.example.cleararch27feb.presetation.FoodViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule= module {
    single <FoodRepository> {FoodDataSourse(api = get())}
}

val domainModule= module {
    factory { FoodUseCase(foodRepository = get()) }
}

val presentationModule= module {
        viewModel { FoodViewModel(foodUseCase = get()) }
}