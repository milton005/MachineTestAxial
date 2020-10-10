package com.pado.machinetest.Data.Models

import com.google.gson.annotations.SerializedName

data class DataItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("brand")
	val brand: List<BrandItem>? = null,

	@field:SerializedName("slug")
	val slug: String? = null
)