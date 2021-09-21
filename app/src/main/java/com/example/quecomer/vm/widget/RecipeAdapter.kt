package com.example.quecomer.vm.widget

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quecomer.R
import com.example.quecomer.data.model.RecipeResponseGet

class RecipeAdapter (var recipeResponseGet: List<RecipeResponseGet>): RecyclerView.Adapter<RecipeHolder>(){

    private lateinit var listener:OnClickListener

    interface OnClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnClickListener(listener2:OnClickListener){
        listener=listener2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeHolder {
       val layoutInflater =LayoutInflater.from(parent.context)
        return RecipeHolder(layoutInflater.inflate(R.layout.item_food, parent, false),listener)
    }

    override fun onBindViewHolder(holder: RecipeHolder, position: Int) {
        holder.render(recipeResponseGet[position])
    }

    override fun getItemCount(): Int {
        return recipeResponseGet.size
    }


}