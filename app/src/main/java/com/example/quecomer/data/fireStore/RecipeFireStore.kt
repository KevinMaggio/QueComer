package com.example.quecomer.data.fireStore

import androidx.lifecycle.MutableLiveData
import com.example.quecomer.data.model.ResponseListRecipe
import com.example.quecomer.data.model.ResponseRecipeByDocument
import com.example.quecomer.utils.State

interface RecipeFireStore {

    suspend fun addRecipe(title:String, description:String, email:String , image:String): State

    fun getRecipe(title:String):MutableLiveData<ResponseRecipeByDocument>

    fun getRecipes(): MutableLiveData<ResponseListRecipe>
}