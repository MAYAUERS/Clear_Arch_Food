package com.example.cleararch27feb.presetation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cleararch27feb.R
import com.example.cleararch27feb.domain.model.FoodResult
import org.koin.androidx.viewmodel.ext.android.viewModel


class FoodFragment : Fragment() {

    private val foodViewModel :FoodViewModel by viewModel()
    private var foodAdapter=FoodAdapter()
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view =inflater.inflate(R.layout.fragment_food,container,false)
        recyclerView= view.findViewById(R.id.recyclerFood)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setLayout()
        observeViewModel()
    }

    private fun setLayout() {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager=LinearLayoutManager(activity)
        recyclerView.adapter=foodAdapter
        foodViewModel.getFoodData()
    }

    private fun observeViewModel() {
        foodViewModel.foodData.observe(viewLifecycleOwner){
            var food: List<FoodResult> = it.results
                if (food!=null){
                    foodAdapter.foodResult=food as ArrayList
                    foodAdapter.notifyDataSetChanged()
                }else{
                    Toast.makeText(activity,"Error occured",Toast.LENGTH_SHORT).show()
                }
        }
        foodViewModel.error.observe(viewLifecycleOwner){
            Toast.makeText(activity,"Error occured"+it,Toast.LENGTH_SHORT).show()
        }
    }
}