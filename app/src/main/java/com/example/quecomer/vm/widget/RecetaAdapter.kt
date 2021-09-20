package com.example.quecomer.vm.widget

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quecomer.R
import com.example.quecomer.data.model.RecetaResponse

class RecetaAdapter (var recetaResponse: List<RecetaResponse>): RecyclerView.Adapter<RecetaHolder>(){

    private lateinit var listener:OnClickListener

    interface OnClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnClickListener(listener2:OnClickListener){
        listener=listener2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecetaHolder {
       val layoutInflater =LayoutInflater.from(parent.context)
        return RecetaHolder(layoutInflater.inflate(R.layout.item_comida, parent, false),listener)
    }

    override fun onBindViewHolder(holder: RecetaHolder, position: Int) {
        holder.render(recetaResponse[position])
    }

    override fun getItemCount(): Int {
        return recetaResponse.size
    }


}