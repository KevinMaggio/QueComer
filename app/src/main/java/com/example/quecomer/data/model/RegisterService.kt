package com.example.quecomer.data.model

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterService {
    @POST("api/register")
    suspend fun postUser(@Body user: User): Response<ApiResponse<RegisterResponse>>
}