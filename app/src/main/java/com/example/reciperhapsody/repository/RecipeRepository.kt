package com.example.reciperhapsody.repository

import com.example.reciperhapsody.data.remote.RecipeApi
import javax.inject.Inject

class RecipeRepository @Inject constructor(
    private val api: RecipeApi
) {

}