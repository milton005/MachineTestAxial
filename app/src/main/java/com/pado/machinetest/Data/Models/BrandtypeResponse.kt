package com.pado.machinetest.Data.Models

import com.google.gson.annotations.SerializedName

data class BrandtypeResponse(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("data")
	val data: List<DataItem>? = null,

	@field:SerializedName("error")
	val error: Any? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)