package com.example.quecomer.ui.recipes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quecomer.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)
    }
}