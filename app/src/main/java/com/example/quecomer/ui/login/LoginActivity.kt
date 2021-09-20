package com.example.quecomer.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quecomer.R
import com.example.quecomer.databinding.ActivityMainBinding
import com.example.quecomer.ui.inicio.HomeActivity
import com.example.quecomer.ui.registro.RegisterActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.SplashTheme)
        Thread.sleep(2000)

        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btIniciar.setOnClickListener{iniciarSesion()}
        binding.btRegistrarse.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }
    }


    fun iniciarSesion(){
        if (!binding.tvIngrediente.text.isNullOrEmpty()){
        val intent=Intent(this, HomeActivity::class.java)
        startActivity(intent)
        }else{
            Toast.makeText(this,"usuario o contraseña invalido",Toast.LENGTH_SHORT).show()
        }
    }




}