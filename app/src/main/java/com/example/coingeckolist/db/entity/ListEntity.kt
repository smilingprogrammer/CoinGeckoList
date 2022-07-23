package com.example.coingeckolist.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lists")
data class ListEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val symbol: String
)