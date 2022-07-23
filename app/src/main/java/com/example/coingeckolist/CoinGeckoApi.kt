package com.example.coingeckolist

import retrofit2.http.GET

interface CoinGeckoApi {

    //Coin Lists
    @GET("coins/list")
    suspend fun getList(): ArrayList<ListResponseItem>
}