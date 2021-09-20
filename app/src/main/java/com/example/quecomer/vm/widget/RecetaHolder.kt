package com.example.quecomer.vm.widget

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.quecomer.databinding.ItemComidaBinding
import com.example.quecomer.data.model.RecetaResponse

class RecetaHolder (val itemView: View, listener: RecetaAdapter.OnClickListener):RecyclerView.ViewHolder(itemView) {
    private  var binding=ItemComidaBinding.bind(itemView)

   fun render(item: RecetaResponse){
       binding.tvItem.text=item.titulo
    }
    init {
        itemView.setOnClickListener{
            listener.onItemClick(adapterPosition)
        }
    }
}