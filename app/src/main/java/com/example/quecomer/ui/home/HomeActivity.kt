package com.example.quecomer.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.quecomer.R
import com.example.quecomer.databinding.ActivityHomeBinding
import com.example.quecomer.ui.login.LoginActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBar.toolbar)
        val navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home_fragment,
                R.id.nav_perfil_fragment,
                R.id.nav_mis_recetas_fragment,
                R.id.nav_cargar_recetas_fragment,
                R.id.nav_recetas_rapidas_fragment,
                R.id.nav_recomendacion_dieta,
                R.id.nav_zona_sin_carnes,
                R.id.nav_pocos_ingredientes
            ),
            binding.drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
        binding.btLogOut.setOnClickListener {
            // loginViewModel.logOut()
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}