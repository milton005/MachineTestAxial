package com.pado.machinetest.Data.Models.Login

import com.google.gson.annotations.SerializedName

data class Data(
	@SerializedName("access_token")
	val accessToken: String? = null,
	@SerializedName("token_type")
	val tokenType: String? = null,
	@SerializedName("expires_in")
	val expiresIn: Int? = null
)
