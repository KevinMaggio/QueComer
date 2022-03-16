package com.example.quecomer.data.model

import com.example.quecomer.utils.State

data class ResponseRecipeByDocument(
    val status: State,
    val data: Recipe
)