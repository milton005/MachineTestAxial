package com.pado.demo.Data.Repository

import com.pado.demo.Data.Remote.ApiHelper
import javax.inject.Inject

class HomeRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun login(email:String?,password:String?)=apiHelper.login(email,password)
    suspend fun getProductS(page:String?,sort_by:String?)=apiHelper.getProductS(page,sort_by)
    suspend fun getBrands()=apiHelper.getBrands()
}