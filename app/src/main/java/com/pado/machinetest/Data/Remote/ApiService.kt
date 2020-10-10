package com.pado.demo.Data.Remote


import com.pado.machinetest.Data.Models.BrandtypeResponse
import com.pado.machinetest.Data.Models.Login.LoginResponse
import com.pado.machinetest.Data.Models.Products.ProductResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

@POST("login?")
@FormUrlEncoded
suspend fun login(@Field("email")email:String?,@Field("password")password:String?):LoginResponse
@GET("get-brand-types")
suspend fun getBrandtypes():BrandtypeResponse

@GET("get-products")
suspend fun getProducts(@Query("page")page:String?,@Query("sort_by")sort_by:String?):ProductResponse
}