package com.example.quecomer.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quecomer.data.model.ResponseListRecipe
import com.example.quecomer.data.model.ResponseRecipeByDocument
import com.example.quecomer.data.repository.RecipeRepository
import com.example.quecomer.utils.State
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipeViewModel : ViewModel() {

    val status = MutableLiveData<State>()
    val recipeRepository = RecipeRepository()

    fun addRecipe(title:String, description: String, email:String , image:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = recipeRepository.addRecipe(title,description,email,image)
            status.postValue(call)
        }
    }

    fun getRecipe(title: String): MutableLiveData<ResponseRecipeByDocument> {
            return recipeRepository.getRecipe(title)
    }

    fun getRecipes(): MutableLiveData<ResponseListRecipe> {
           return recipeRepository.getRecipes()
    }
}