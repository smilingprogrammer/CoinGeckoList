package com.example.coingeckolist.network

import com.example.coingeckolist.model.ListResponseItem
import retrofit2.http.GET

interface CoinGeckoApi {

    //Coin Lists
    @GET("coins/list")
    suspend fun getList(): ArrayList<ListResponseItem>
}