package com.example.quecomer.ui.recipes

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.quecomer.data.model.RecipeResponseGet
import com.example.quecomer.data.repository.RecipesRepository

class RecipeViewModel @ViewModelInject constructor(val recipesRepository: RecipesRepository) :
    ViewModel() {

 fun getLista(): List<RecipeResponseGet> {
     return recipesRepository.listaRecipeGets
 }
}