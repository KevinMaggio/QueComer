package com.example.quecomer.vm.widget

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.quecomer.data.model.RecipeResponseGet
import com.example.quecomer.databinding.ItemFoodBinding

class RecipeHolder (val itemView: View, listener: RecipeAdapter.OnClickListener):RecyclerView.ViewHolder(itemView) {
    private  var binding= ItemFoodBinding.bind(itemView)

   fun render(item: RecipeResponseGet){
       binding.tvItem.text=item.titulo
    }
    init {
        itemView.setOnClickListener{
            listener.onItemClick(adapterPosition)
        }
    }
}