package com.example.coingeckolist.viewmodel

import androidx.lifecycle.*
import androidx.lifecycle.ViewModel
import com.example.coingeckolist.repository.Repository
import com.example.coingeckolist.model.response.BaseResponse
import kotlinx.coroutines.Dispatchers

class ViewModel: ViewModel(){

    private val dispatcher = Dispatchers.IO
    private val repository = Repository()

    private suspend fun getCoinList() =
        repository.getList()

    fun getList() = liveData(dispatcher) {
        emit(BaseResponse.load(data = null))
        try {
            emit(BaseResponse.successfull(data = getCoinList()))
        } catch (e: Exception) {
            emit(BaseResponse.error(data = null, msg = e.message ?: "Error Occurred!"))
        }
    }

}