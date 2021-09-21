package com.example.quecomer.data.model

import com.google.gson.annotations.SerializedName

data class RecetaResponsePost(
    @SerializedName("respuesta") var respuesta: Boolean
)