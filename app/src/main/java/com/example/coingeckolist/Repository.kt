package com.example.coingeckolist


class Repository {

    private val apiService = ApiClient.retrofitService
    suspend fun getList() = apiService.getList()
}