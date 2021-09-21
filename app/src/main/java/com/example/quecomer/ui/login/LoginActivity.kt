package com.example.quecomer.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quecomer.R
import com.example.quecomer.databinding.ActivityLoginBinding
import com.example.quecomer.ui.home.HomeActivity
import com.example.quecomer.ui.register.RegisterActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.SplashTheme)
        Thread.sleep(2000)

        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btIniciar.setOnClickListener{login()}
        binding.btRegistrarse.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }
    }


    fun login(){
        if (!binding.tvIngrediente.text.isNullOrEmpty()){
        val intent=Intent(this, HomeActivity::class.java)
        startActivity(intent)
        }else{
            Toast.makeText(this,"usuario o contraseña invalido",Toast.LENGTH_SHORT).show()
        }
    }




}