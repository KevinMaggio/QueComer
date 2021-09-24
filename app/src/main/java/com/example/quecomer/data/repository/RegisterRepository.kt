package com.example.quecomer.data.repository


import com.example.quecomer.data.model.RegisterDataSource
import com.example.quecomer.data.model.User
import javax.inject.Inject

class RegisterRepository @Inject constructor(private val registerDataSource: RegisterDataSource) {

/*    suspend fun register(name:String,email:String,pass:String)=
        registerDataSource.addUser(User(name,email,pass))*/

}