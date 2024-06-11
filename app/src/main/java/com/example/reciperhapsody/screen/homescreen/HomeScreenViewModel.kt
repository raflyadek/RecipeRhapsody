package com.example.reciperhapsody.screen.homescreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.reciperhapsody.data.RecipeListEntry
import com.example.reciperhapsody.repository.RecipeRepository
import com.example.reciperhapsody.util.Constants.PAGE_SIZE
import com.example.reciperhapsody.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: RecipeRepository
) : ViewModel() {
    private var curPage = 0
    private var cachedRecipeList = listOf<RecipeListEntry>()
    private var isSearchingStarted = true

    var isSearching = mutableStateOf(false)
    var recipeList = mutableStateOf<List<RecipeListEntry>>(listOf())
    var isLoading = mutableStateOf(false)
    var loadError = mutableStateOf("")
    var endReached = mutableStateOf(false)

    fun searchRecipeList(query: String) {
        val listToSearch = if (isSearchingStarted) {
            recipeList.value
        } else {
            cachedRecipeList
        }
        viewModelScope.launch(Dispatchers.Default) {
            if (query.isEmpty()) {
                recipeList.value = cachedRecipeList
                isSearching.value = false
                isSearchingStarted = true
                return@launch
            }
            val results = listToSearch.filter {
                it.recipeName.contains(query.trim(), ignoreCase = true) ||
                        it.number.toString() == query.trim()
            }
            if (isSearchingStarted) {
                cachedRecipeList = recipeList.value
                isSearchingStarted = false
            }
            recipeList.value = results
            isSearching.value = true
        }
    }

//    fun loadRecipePaginated() {
//        viewModelScope.launch {
//            isLoading.value = true
//            val result = repository.getRecipeList(PAGE_SIZE, curPage * PAGE_SIZE)
//            when(result) {
//                is Resource.Success -> {
////                    endReached.value = curPage * PAGE_SIZE >= result.data!!.totalResults
////                    val recipeEntries = result.data.results.mapIndexed { index, entry ->
////                        val number = if(entry.url)
////                    }
//                }
//            }
//        }
//    }
}