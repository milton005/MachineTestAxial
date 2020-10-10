package com.pado.machinetest.Data.Models.Products

import com.google.gson.annotations.SerializedName

data class DataItem(

	@field:SerializedName("images")
	val images: List<Any?>? = null,

	@field:SerializedName("created")
	val created: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("variants")
	val variants: List<VariantsItem?>? = null,

	@field:SerializedName("category")
	val category: Category? = null,

	@field:SerializedName("stock")
	val stock: List<Any?>? = null,

	@field:SerializedName("brand")
	val brand: Brand? = null,

	@field:SerializedName("brand_type")
	val brandType: BrandType? = null
)