package com.example.coingeckolist

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeList(coinList: MutableList<ListResponseItem>) {
    Scaffold { innerPadding->
        LazyColumn(contentPadding = innerPadding){
            itemsIndexed(
                items = coinList
            ) { index, item ->
                ListItem(listResponseItem = item, index)
            }
        }
    }
}

@Composable
fun ListItem(
    listResponseItem: ListResponseItem, position: Int
){
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column {
            Text(text = listResponseItem.id, style = MaterialTheme.typography.h6)
            Text(text = listResponseItem.name, style = MaterialTheme.typography.h6)
            Text(text = listResponseItem.symbol, style = MaterialTheme.typography.h6)
        }
    }
}