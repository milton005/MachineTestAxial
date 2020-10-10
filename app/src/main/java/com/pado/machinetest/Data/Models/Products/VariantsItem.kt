package com.pado.machinetest.Data.Models.Products

import com.google.gson.annotations.SerializedName

data class VariantsItem(

	@field:SerializedName("images")
	val images: List<Any?>? = null,

	@field:SerializedName("alert")
	val alert: Int? = null,

	@field:SerializedName("wholesale_price")
	val wholesalePrice: Int? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("attributes")
	val attributes: List<AttributesItem?>? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("sku")
	val sku: String? = null,

	@field:SerializedName("retail_price")
	val retailPrice: Int? = null
)