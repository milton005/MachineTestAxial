package com.pado.machinetest.Data.Models.Products

import com.google.gson.annotations.SerializedName

data class AttributesItem(

	@field:SerializedName("attribute_id")
	val attributeId: Int? = null,

	@field:SerializedName("value_id")
	val valueId: Int? = null,

	@field:SerializedName("attribute")
	val attribute: Attribute? = null,

	@field:SerializedName("value")
	val value: String? = null,

	@field:SerializedName("slug")
	val slug: Any? = null
)