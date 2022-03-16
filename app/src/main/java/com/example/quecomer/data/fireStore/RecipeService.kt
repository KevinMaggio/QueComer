package com.example.quecomer.data.fireStore

import androidx.lifecycle.MutableLiveData
import com.example.quecomer.data.model.Recipe
import com.example.quecomer.data.model.ResponseListRecipe
import com.example.quecomer.data.model.ResponseRecipeByDocument
import com.example.quecomer.utils.State
import com.google.firebase.firestore.FirebaseFirestore

class RecipeService : RecipeFireStore {

    private val fireStore = FirebaseFirestore.getInstance()
    private var recipe = Recipe("","","","")
    private var status = State.LOADING
    var liveRecipes = MutableLiveData<ResponseListRecipe>()
    var liveRecipe = MutableLiveData<ResponseRecipeByDocument>()



    override suspend fun addRecipe(title: String, description: String, email:String , image:String): State {
        if(fireStore.collection("recipes").document(title).set(
            hashMapOf(
            "title" to title,
            "description" to description,
                "email" to email,
                "image" to image
        )).isCanceled){
            status = State.ERROR

        }else{
            status = State.SUCCES
        }
        return status
    }

    override fun getRecipe(title: String): MutableLiveData<ResponseRecipeByDocument> {
        fireStore.collection("recipes").document(title).get().addOnSuccessListener {

            recipe = Recipe(it.get("title").toString(),it.get("description").toString(),it.get("email").toString(),it.get("image").toString())
             liveRecipe.postValue(ResponseRecipeByDocument(State.SUCCES,recipe))
        }
       return liveRecipe
    }

    override fun getRecipes(): MutableLiveData<ResponseListRecipe> {

        var lista = mutableListOf<String>()
        fireStore.collection("recipes").get().addOnSuccessListener { it ->

                for (i in it.documents){
                    lista.add(i.id)
                }

            liveRecipes.postValue(ResponseListRecipe(lista,State.SUCCES))
        }
            return liveRecipes
    }
}