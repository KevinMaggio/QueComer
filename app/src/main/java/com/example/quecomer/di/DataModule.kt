package com.example.quecomer.di

import android.content.Context
import com.example.quecomer.data.Preferences
import com.example.quecomer.data.RecipeService
import com.example.quecomer.data.model.RegisterDataSource
import com.example.quecomer.data.model.RegisterService
import com.example.quecomer.data.repository.RecipesRepository
import com.example.quecomer.data.repository.RegisterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(ApplicationComponent::class)
class DataModule {

    val API_URL = "http://ongapi.alkemy.org/"

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
    fun provideRecipeService(@ApiQueComer retrofit: Retrofit) =
        retrofit.create(RecipeService::class.java)

    @Provides
    fun provideRecetasRepository(recipeService: RecipeService):RecipesRepository{
        return RecipesRepository(recipeService)
    }

    @Provides
    fun providePreference(@ApplicationContext context: Context): Preferences {
        return Preferences(context)
    }

    @Provides
    fun provideRegisterService(@ApiQueComer retrofit: Retrofit) =
        retrofit.create(RegisterService::class.java)

    @Provides
    fun provideRegisterDataSource(registerService: RegisterService): RegisterDataSource {
        return RegisterDataSource(registerService)
    }
    @Provides
    fun providesRegisterRepository(registerDataSource: RegisterDataSource):RegisterRepository{
        return RegisterRepository(registerDataSource)
    }
}