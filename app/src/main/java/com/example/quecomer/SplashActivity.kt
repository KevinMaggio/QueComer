package com.example.quecomer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.quecomer.data.Preferences
import com.example.quecomer.databinding.ActivitySplashBinding
import com.example.quecomer.ui.home.HomeActivity
import com.example.quecomer.ui.login.LoginActivity
import com.example.quecomer.ui.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private val loginViewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Thread.sleep(2000)
        goTo()
    }

    fun goTo() {
        if (loginViewModel.isUserLogged()) {
            startActivity(Intent(this, HomeActivity::class.java))
        } else {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
