package com.example.coingeckolist.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.coingeckolist.MainActivityToolbar
import com.example.coingeckolist.R
import com.example.coingeckolist.model.ListResponseItem
import com.example.coingeckolist.ui.theme.Purple700

@Composable
fun HomeLayout(
    listResponseItem: MutableList<ListResponseItem>, isLoading: Boolean
){
    if (isLoading) {
        Column() {
            TopAppBar(title = { Text(text = stringResource(R.string.home_title)) }, backgroundColor = Purple700)
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator()
            }
        }
    } else {
        MainActivityToolbar(listResponseItem = listResponseItem)
    }
}