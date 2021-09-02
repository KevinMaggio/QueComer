package com.example.quecomer.model.recyclerView

import android.view.View
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.quecomer.databinding.ItemComidaBinding
import com.example.quecomer.model.data.Receta
import com.example.quecomer.model.data.RecetaResponse

class RecetaHolder (val itemView: View):RecyclerView.ViewHolder(itemView) {
    private  var binding=ItemComidaBinding.bind(itemView)

   fun render(item: RecetaResponse){
       binding.tvItem.text=item.titulo
    }
}