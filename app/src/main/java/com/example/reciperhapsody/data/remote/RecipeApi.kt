package com.example.reciperhapsody.data.remote

import com.example.reciperhapsody.data.remote.response.RecipeInfo
import com.example.reciperhapsody.data.remote.response.RecipeList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeApi {

    //Get recipe list
    @GET("recipes/complexSearch")
    suspend fun getRecipeList(
      @Query("limit") limit: Int,
      @Query("offset") offset: Int
    ): RecipeList

    //Get recipe info by id using path
    @GET("recipes/{id}/information")
    suspend fun getRecipeInfoById(
        @Path("id") id: Int
    ): RecipeInfo
}