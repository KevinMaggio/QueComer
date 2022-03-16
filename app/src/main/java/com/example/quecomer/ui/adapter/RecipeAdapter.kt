package com.example.quecomer.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quecomer.R
import com.example.quecomer.data.model.Recipe
import com.example.quecomer.databinding.ItemRecipeBinding

class RecipeAdapter(val list: List<String>): RecyclerView.Adapter<RecipeHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position:Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        mListener=listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe,parent,false)
        return RecipeHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: RecipeHolder, position: Int) {
        holder.render(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
class RecipeHolder(view:View, listener:RecipeAdapter.onItemClickListener) : RecyclerView.ViewHolder(view){

    private val binding = ItemRecipeBinding.bind(view)

    fun render(recipe : String){
        binding.tvTitle.text= recipe
    }
    init {
        view.setOnClickListener {
            listener.onItemClick(adapterPosition)
        }
    }
}