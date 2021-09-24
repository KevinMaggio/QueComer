package com.example.quecomer.data.model

import com.google.gson.annotations.SerializedName

data class ApiResponse<T>(
    @SerializedName("success") var succes: Boolean,
    @SerializedName("data") var data: T,
    @SerializedName("message") var message: String
)