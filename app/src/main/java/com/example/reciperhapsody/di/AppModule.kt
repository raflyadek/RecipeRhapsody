package com.example.reciperhapsody.di

import com.example.reciperhapsody.data.remote.RecipeApi
import com.example.reciperhapsody.repository.RecipeRepository
import com.example.reciperhapsody.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        api: RecipeApi
    ) = RecipeRepository(api)

    @Singleton
    @Provides
    fun provideRecipeApi(): RecipeApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(RecipeApi::class.java)
    }
}