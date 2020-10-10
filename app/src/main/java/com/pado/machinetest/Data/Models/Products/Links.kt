package com.pado.machinetest.Data.Models.Products

import com.google.gson.annotations.SerializedName

data class Links(

	@field:SerializedName("next")
	val next: String? = null,

	@field:SerializedName("last")
	val last: String? = null,

	@field:SerializedName("prev")
	val prev: String? = null,

	@field:SerializedName("first")
	val first: String? = null
)