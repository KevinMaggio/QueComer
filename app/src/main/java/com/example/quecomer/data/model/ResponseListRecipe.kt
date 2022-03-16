package com.example.quecomer.data.model

import com.example.quecomer.utils.State

data class ResponseListRecipe(
    val data : List<String>,
    val status : State
)
