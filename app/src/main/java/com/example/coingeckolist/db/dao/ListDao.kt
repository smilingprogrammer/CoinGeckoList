package com.example.coingeckolist.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query
import com.example.coingeckolist.db.entity.ListEntity
import java.util.concurrent.Flow

interface ListDao {

    @Insert
    suspend fun insertList(list: List<ListEntity>)

    @Query("SELECT * FROM lists")
    fun getCoins(): LiveData<List<ListEntity>>
}