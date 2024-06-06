package com.example.reciperhapsody.data.remote

import com.example.reciperhapsody.data.remote.response.ResultsItem
import com.example.reciperhapsody.data.remote.response.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeApi {

    //Get recipe list
    @GET("recipes/complexSearch")
    suspend fun getRecipe(
      @Query("limit") limit: Int,
      @Query("offset") offset: Int
    ): SearchResponse

    //Get recipe info by id using path
    @GET("recipes/{id}/information")
    suspend fun getRecipeInfo(
        @Path("id") id: Int
    ): ResultsItem
}