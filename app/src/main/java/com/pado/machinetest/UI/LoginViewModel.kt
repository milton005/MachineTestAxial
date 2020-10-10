package com.pado.machinetest.UI

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.pado.demo.Data.Remote.ApiService
import com.pado.demo.Data.Repository.HomeRepository
import com.pado.demo.Utils.Resource
import kotlinx.coroutines.Dispatchers

class LoginViewModel @ViewModelInject constructor(private val homeRepository: HomeRepository):ViewModel(){

    fun login(email:String?,password:String?)= liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = homeRepository.login(email,password)))

        }catch (e:Exception)
        {
            emit(Resource.error(data = null,message = "error"))
        }
    }

}