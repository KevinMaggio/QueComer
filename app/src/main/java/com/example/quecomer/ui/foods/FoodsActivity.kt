package com.example.quecomer.ui.foods

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quecomer.databinding.ActivityFoodsBinding
import com.example.quecomer.ui.recipes.RecipeActivity
import com.example.quecomer.ui.recipes.RecipeViewModel
import com.example.quecomer.vm.widget.RecipeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodsActivity : AppCompatActivity() {

   private  lateinit var binding: ActivityFoodsBinding
   private val recetasViewModel by viewModels<RecipeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
       binding = ActivityFoodsBinding.inflate(layoutInflater)
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
        val adapter = RecipeAdapter(recetasViewModel.getLista())



                adapter.setOnClickListener(object : RecipeAdapter.OnClickListener {
            override fun onItemClick(position: Int) {
                val intent= Intent(this@FoodsActivity, RecipeActivity::class.java)
              //  intent.putExtra("posicion", recetasRepository.get(position).id.toString())
                startActivity(intent)
            }
        })
        binding.rvComidas.layoutManager = LinearLayoutManager(this)
         binding.rvComidas.adapter=adapter

    }
}