package com.example.reciperhapsody.screen.homescreen

import androidx.lifecycle.ViewModel
import com.example.reciperhapsody.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: RecipeRepository
) : ViewModel() {


}