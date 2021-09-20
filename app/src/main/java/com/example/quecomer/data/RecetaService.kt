package com.example.quecomer.data

import com.example.quecomer.data.model.PostRecetaResponse
import com.example.quecomer.data.model.RecetaResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface RecetaService{
    @POST("Aca La URL")
    suspend fun  postRecetas(@Body receta:String): Response<PostRecetaResponse>

    @GET ("la URL aca")
    suspend fun getRecetas(@Query ("aca el parametro") receta:String): Response<RecetaResponse>

}