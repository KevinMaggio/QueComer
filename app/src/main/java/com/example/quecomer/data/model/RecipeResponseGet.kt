package com.example.quecomer.data.model

import com.google.gson.annotations.SerializedName

data class RecipeResponseGet (

    @SerializedName("titulo") val titulo :String,
    @SerializedName("descripcion")val descripcion:String,
    @SerializedName("id")val id:Int,
    @SerializedName("imagen")val imagen:String

        )