package com.example.quecomer.ui.comidas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quecomer.databinding.ActivityComidasBinding
import com.example.quecomer.ui.recetas.RecetaActivity
import com.example.quecomer.ui.recetas.RecetasViewModel
import com.example.quecomer.vm.widget.RecetaAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComidasActivity : AppCompatActivity() {

   private  lateinit var binding: ActivityComidasBinding
   private val recetasViewModel by viewModels<RecetasViewModel>()

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
        val adapter = RecetaAdapter(recetasViewModel.getLista())



                adapter.setOnClickListener(object : RecetaAdapter.OnClickListener {
            override fun onItemClick(position: Int) {
                val intent= Intent(this@ComidasActivity, RecetaActivity::class.java)
              //  intent.putExtra("posicion", recetasRepository.get(position).id.toString())
                startActivity(intent)
            }
        })
        binding.rvComidas.layoutManager = LinearLayoutManager(this)
         binding.rvComidas.adapter=adapter

    }
}