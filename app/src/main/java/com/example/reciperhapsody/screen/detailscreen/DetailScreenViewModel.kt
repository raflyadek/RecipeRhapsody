package com.example.reciperhapsody.screen.detailscreen

import androidx.lifecycle.ViewModel
import com.example.reciperhapsody.data.remote.response.RecipeInfo
import com.example.reciperhapsody.repository.RecipeRepository
import com.example.reciperhapsody.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    private val repository: RecipeRepository
) : ViewModel() {

    suspend fun getRecipeInfo(recipeId: Int): Resource<RecipeInfo> {
        return repository.getRecipeInfo(recipeId)
    }
}