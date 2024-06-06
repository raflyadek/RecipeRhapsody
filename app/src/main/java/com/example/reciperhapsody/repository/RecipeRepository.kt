package com.example.reciperhapsody.repository

import com.example.reciperhapsody.data.remote.RecipeApi
import com.example.reciperhapsody.data.remote.response.RecipeList
import com.example.reciperhapsody.data.remote.response.RecipeInfo
import com.example.reciperhapsody.util.Resource
import javax.inject.Inject

class RecipeRepository @Inject constructor(
    private val api: RecipeApi
) {
    suspend fun getRecipeList(limit: Int, offset: Int): Resource<RecipeList> {
        val response = try {
            api.getRecipeList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("Unknown error.")
        }
        return Resource.Success(response)
    }

    suspend fun getRecipeInfo(recipeId: Int): Resource<RecipeInfo> {
        val response = try {
            api.getRecipeInfo(recipeId)
        } catch (e: Exception) {
            return Resource.Error("Unknown error.")
        }
        return Resource.Success(response)
    }
}