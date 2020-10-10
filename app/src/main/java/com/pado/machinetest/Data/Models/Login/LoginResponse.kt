package com.pado.machinetest.Data.Models.Login

import com.google.gson.annotations.SerializedName

data class LoginResponse(
	@SerializedName("code")
	val code: Int? = null,
	@SerializedName("data")
	val data: Data? = null,
	val error: Any? = null,
	@SerializedName("status")
	val status: Boolean? = null
)
