package com.pado.machinetest.Data.Models

import com.google.gson.annotations.SerializedName

data class BrandItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("slug")
	val slug: Any? = null
)