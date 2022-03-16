package com.example.quecomer.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.quecomer.data.dataSource.RecipeDataSource
import com.example.quecomer.data.model.ResponseListRecipe
import com.example.quecomer.data.model.ResponseRecipeByDocument
import com.example.quecomer.utils.State

class RecipeRepository {
    val recipeDataSource = RecipeDataSource()

    suspend fun addRecipe(title:String, description: String, email:String , image:String): State {
       return recipeDataSource.addRecipe(title, description,email,image)
    }

    fun getRecipe(title: String): MutableLiveData<ResponseRecipeByDocument> {
        return recipeDataSource.getRecipe(title)
    }
    fun getRecipes(): MutableLiveData<ResponseListRecipe> {
        return recipeDataSource.getRecipes()
    }
}