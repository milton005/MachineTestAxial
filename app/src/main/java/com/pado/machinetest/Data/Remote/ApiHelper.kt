package com.pado.demo.Data.Remote

import javax.inject.Inject

open class ApiHelper @Inject constructor(private val apiService: ApiService) {

suspend fun login(email:String?,password:String?)=apiService.login(email,password)
suspend fun getProductS(page:String?,sort_by:String?)=apiService.getProducts(page,sort_by)
    suspend fun getBrands()=apiService.getBrandtypes()

}