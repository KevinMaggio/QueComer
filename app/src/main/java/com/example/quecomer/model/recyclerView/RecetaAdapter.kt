package com.example.quecomer.model.recyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quecomer.R
import com.example.quecomer.model.data.RecetaResponse

class RecetaAdapter (var recetaResponse: List<RecetaResponse>): RecyclerView.Adapter<RecetaHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecetaHolder {
       val layoutInflater =LayoutInflater.from(parent.context)
        return RecetaHolder(layoutInflater.inflate(R.layout.item_comida, parent, false))
    }

    override fun onBindViewHolder(holder: RecetaHolder, position: Int) {
        holder.render(recetaResponse[position])
    }

    override fun getItemCount(): Int {
        return recetaResponse.size
    }


}