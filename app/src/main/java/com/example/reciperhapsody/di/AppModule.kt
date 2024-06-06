package com.example.reciperhapsody.di

import com.example.reciperhapsody.BuildConfig
import com.example.reciperhapsody.data.remote.RecipeApi
import com.example.reciperhapsody.repository.RecipeRepository
import com.example.reciperhapsody.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
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
        val client = OkHttpClient.Builder()
            .addInterceptor { apiKeyAsHeader(it) }
            .build()
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(client)
            .build()
            .create(RecipeApi::class.java)
    }

    @Singleton
    @Provides
    private fun apiKeyAsHeader(it: Interceptor.Chain) = it.proceed(
        it.request()
            .newBuilder()
            .addHeader("x-api-key", BuildConfig.API_KEY)
            .build()
    )
}