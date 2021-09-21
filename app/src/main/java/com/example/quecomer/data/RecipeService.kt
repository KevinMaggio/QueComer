package com.example.quecomer.data

import com.example.quecomer.data.model.RecetaResponsePost
import com.example.quecomer.data.model.RecipeResponseGet
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface RecipeService{
    @POST("Aca La URL")
    suspend fun  postRecetas(@Body receta:String): Response<RecetaResponsePost>

    @GET ("la URL aca")
    suspend fun getRecetas(@Query ("aca el parametro") receta:String): Response<RecipeResponseGet>

}