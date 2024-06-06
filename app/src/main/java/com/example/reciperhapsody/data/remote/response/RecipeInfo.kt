package com.example.reciperhapsody.data.remote.response

import com.google.gson.annotations.SerializedName

data class RecipeInfo(

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("imageType")
	val imageType: String
)