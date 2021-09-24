package com.example.quecomer.data.repository

class LoginRepository {

    //mook
    private var user=""
    private var pass=""
    //*****//
    fun login(user:String,pass:String ){
        this.user=user
        this.pass=pass
    }
}