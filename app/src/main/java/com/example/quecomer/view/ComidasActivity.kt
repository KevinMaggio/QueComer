package com.example.quecomer.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quecomer.R
import com.example.quecomer.databinding.ActivityComidasBinding
import com.example.quecomer.model.recyclerView.RecetaAdapter
import com.example.quecomer.repository.RecetasRepository

class ComidasActivity : AppCompatActivity() {

   private  lateinit var binding: ActivityComidasBinding
    private  var recetasRepository=RecetasRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
       binding = ActivityComidasBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        filtroTiempo()

        initRecycler()
    }
    fun filtroTiempo(){
        binding.btTiempo.setOnClickListener {  } // agregar filtro
    }

    fun initRecycler(){
        binding.rvComidas.layoutManager = LinearLayoutManager(this)
        val adapter = RecetaAdapter(recetasRepository.listaRecetas)
        binding.rvComidas.adapter=adapter
    }
}