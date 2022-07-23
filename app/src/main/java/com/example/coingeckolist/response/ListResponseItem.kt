package com.example.coingeckolist.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ListResponseItem(

    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("symbol")
    val symbol: String
): Serializable