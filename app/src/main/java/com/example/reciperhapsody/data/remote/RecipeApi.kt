package com.example.reciperhapsody.data.remote

import retrofit2.http.GET

interface RecipeApi {

    @GET
    suspend fun getRecipe(){

    }
}