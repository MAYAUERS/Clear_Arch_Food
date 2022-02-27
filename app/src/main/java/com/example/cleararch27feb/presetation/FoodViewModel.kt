package com.example.cleararch27feb.presetation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleararch27feb.domain.model.Food
import com.example.cleararch27feb.domain.useCase.FoodUseCase
import kotlinx.coroutines.launch

class FoodViewModel(private val foodUseCase: FoodUseCase):ViewModel() {

    val foodData: LiveData<Food> get() =_foodData
    var _foodData = MutableLiveData<Food>()

    val error :LiveData<String> get() =_error
    var _error =MutableLiveData<String> ()


    fun getFoodData() {

        viewModelScope.launch {
            var response= foodUseCase.invoke()
            if (response.isSuccessful){
                _foodData.value=response.body()
            }else{
                _error.value=response.errorBody().toString()
            }
        }
    }
}