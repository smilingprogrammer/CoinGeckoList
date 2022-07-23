package com.example.coingeckolist.repository

import com.example.coingeckolist.network.ApiClient


class Repository {

    private val apiService = ApiClient.retrofitService
    suspend fun getList() = apiService.getList()
}