package com.example.quecomer.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quecomer.R
import com.example.quecomer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.SplashTheme)
        Thread.sleep(2000)

        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btBuscar.setOnClickListener{navegarReceta()}
    }



    fun buscar(){

    }

    fun navegarReceta(){
        val intent=Intent(this,ComidasActivity::class.java)
        startActivity(intent)

    }
}