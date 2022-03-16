package com.example.quecomer.data.dataSource

import androidx.lifecycle.MutableLiveData
import com.example.quecomer.data.fireStore.RecipeService
import com.example.quecomer.data.model.ResponseListRecipe
import com.example.quecomer.data.model.ResponseRecipeByDocument
import com.example.quecomer.utils.State

class RecipeDataSource {

    val recipeService = RecipeService()

    suspend fun addRecipe(title: String, description: String, email:String , image:String): State {
       return recipeService.addRecipe(title, description,email,image)
    }

    fun getRecipe(title: String): MutableLiveData<ResponseRecipeByDocument> {
        return recipeService.getRecipe(title)
    }

    fun getRecipes(): MutableLiveData<ResponseListRecipe> {
        return recipeService.getRecipes()

    }
}