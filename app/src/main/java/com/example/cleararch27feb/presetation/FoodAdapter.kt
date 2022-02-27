package com.example.cleararch27feb.presetation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cleararch27feb.R
import com.example.cleararch27feb.domain.model.Food
import com.example.cleararch27feb.domain.model.FoodResult

class FoodAdapter :RecyclerView.Adapter<FoodAdapter.FoodViewHolder>(){

    var foodResult = ArrayList<FoodResult>()
    class FoodViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {

        var country=itemView.findViewById<TextView>(R.id.textView_country)
        var city=itemView.findViewById<TextView>(R.id.textView_city)
        var state=itemView.findViewById<TextView>(R.id.textView_state)

        fun bindViews(foodResult: FoodResult){
            country.text=foodResult.country
            city.text=foodResult.city
            state.text=foodResult.state
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAdapter.FoodViewHolder {
       var view=LayoutInflater.from(parent.context).inflate(R.layout.food_items,parent,false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodAdapter.FoodViewHolder, position: Int) {
      holder.bindViews(foodResult[position])
    }

    override fun getItemCount(): Int {
       return foodResult.size
    }
}