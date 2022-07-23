package com.example.coingeckolist.db

import com.example.coingeckolist.db.entity.ListEntity
import com.example.coingeckolist.model.ListResponseItem

fun ListEntity.toModel() = ListResponseItem(
    id = id,
    symbol = symbol,
    name = name,
)

fun ListResponseItem.toDbEntity() = ListEntity(
    id = id,
    symbol = symbol,
    name = name,
)

fun List<ListEntity>.toModel() = map { it.toModel() }

fun List<ListResponseItem>.toDbEntity() = map { it.toDbEntity() }