package com.example.quecomer.ui.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.quecomer.data.Preferences
import com.example.quecomer.data.repository.LoginRepository

class LoginViewModel @ViewModelInject constructor(private val preferences: Preferences) : ViewModel() {

//injectar esto
private val loginRepository=LoginRepository()


    fun login(user:String, password:String){
        loginRepository.login(user,password)
        preferences.saveUserToken(user)

    }
    fun isUserLogged():Boolean{
    return (preferences.getUserToken().isNotEmpty())
    }
    fun logOut(){
        preferences.clear()
    }
}