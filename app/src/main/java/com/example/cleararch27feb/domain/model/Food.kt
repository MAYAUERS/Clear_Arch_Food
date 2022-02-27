package com.example.cleararch27feb.domain.model


data class Food(var results:List<FoodResult>)
data class FoodResult(var country:String,var city:String,var state:String)