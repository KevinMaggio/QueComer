package com.example.quecomer.data.model


import BaseDataSource
import javax.inject.Inject

class RegisterDataSource @Inject constructor(private val registerService: RegisterService) //:BaseDataSource()
{

   // suspend fun addUser(user: User) = getResult { registerService.postUser(user) }
}