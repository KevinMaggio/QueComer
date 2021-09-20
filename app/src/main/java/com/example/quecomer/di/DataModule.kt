package com.example.quecomer.di

import com.example.quecomer.data.RecetaService
import com.example.quecomer.data.repository.RecetasRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(ApplicationComponent::class)
class DataModule {

    val API_URL = "aca la Url base"

    @ApiQueComer
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
        .baseUrl(API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Provides
    fun provideOkHttpClient() = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    //instance de recetaService (Interface)
    @Provides
    fun provideRegisterService(@ApiQueComer retrofit: Retrofit) =
        retrofit.create(RecetaService::class.java)

    @Provides
    fun provideRecetasRepository(recetaService: RecetaService):RecetasRepository{
        return RecetasRepository(recetaService)
    }
}