package com.pado.machinetest.Data.Models.Products

import com.google.gson.annotations.SerializedName

data class Category(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("slug")
	val slug: Any? = null
)