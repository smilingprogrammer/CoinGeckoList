package com.example.coingeckolist.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.coingeckolist.db.dao.ListDao
import com.example.coingeckolist.db.toDbEntity
import com.example.coingeckolist.db.toModel
import com.example.coingeckolist.model.ListResponseItem
import com.example.coingeckolist.network.ApiClient
import com.example.coingeckolist.network.CoinGeckoApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class RepositoryImpl(
    private val baseService: CoinGeckoApi,
    private val dao: ListDao,
): BaseRepository {
    override suspend fun getList(): LiveData<List<ListResponseItem>> = withContext(Dispatchers.IO){
        runCatching {
            baseService.getList()
        }.onSuccess {
            dao.insertList(it.toDbEntity())
        }
        dao.getCoins().map { it.toModel() }
    }


}

interface BaseRepository {
    suspend fun getList(): LiveData<List<ListResponseItem>>
}