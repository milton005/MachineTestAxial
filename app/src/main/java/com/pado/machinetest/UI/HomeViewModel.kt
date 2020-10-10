package com.pado.machinetest.UI

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.pado.demo.Data.Repository.HomeRepository
import com.pado.demo.Utils.Resource
import kotlinx.coroutines.Dispatchers

class HomeViewModel @ViewModelInject constructor(private val homeRepository: HomeRepository):ViewModel() {
    fun getBrands()= liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data =homeRepository.getBrands() ))

        }catch (e:Exception)
        {
            emit(Resource.error(data = null,message = "error"))
        }
    }
    fun getProducts(page:String?,sort_by:String)=
        liveData(Dispatchers.IO) {
            emit(Resource.loading(data = null))
            try {
                emit(Resource.success(data =homeRepository.getProductS(page,sort_by) ))

            }catch (e:Exception)
            {
                emit(Resource.error(data = null,message = "error"))
            }
        }

}