package com.example.quecomer.ui.register

data class RegisterFormState(
    val emailError: Int? = null,
    val passwordError: Int? = null,
    val confirmedPasswordError:Int?=null,
    val isDataValid: Boolean = false
)