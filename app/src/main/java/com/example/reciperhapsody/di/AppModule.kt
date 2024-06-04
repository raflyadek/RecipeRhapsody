package com.example.reciperhapsody.di

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
            .addInterceptor { chain -> return@addInterceptor addApiKey(chain) }
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(RecipeApi::class.java)
    }
    private fun addApiKey(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        val originalHttpUrl = chain.request().url
        val newUrl = originalHttpUrl.newBuilder()
            .addQueryParameter("apiKey", "my_api_key").build()
        request.url(newUrl)
        return chain.proceed(request.build())
    }
}