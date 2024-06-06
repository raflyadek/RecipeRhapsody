package com.example.reciperhapsody.data.remote.response

import com.google.gson.annotations.SerializedName

data class RecipeList(

	@field:SerializedName("number")
	val number: Int,

	@field:SerializedName("totalResults")
	val totalResults: Int,

	@field:SerializedName("offset")
	val offset: Int,

	@field:SerializedName("results")
	val results: List<ResultsItem>
)