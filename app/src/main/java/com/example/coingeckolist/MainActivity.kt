package com.example.coingeckolist

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.coingeckolist.response.ApiStatus
import com.example.coingeckolist.response.ListResponseItem
import com.example.coingeckolist.ui.theme.CoinGeckoListTheme
import com.example.coingeckolist.ui.theme.Purple700
import com.example.coingeckolist.view.HomeLayout
import com.example.coingeckolist.viewmodel.ViewModel

class MainActivity : ComponentActivity() {

    private var isLoading: Boolean by mutableStateOf(false)
    private var coinList = mutableListOf<ListResponseItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoinGeckoListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomeLayout(listResponseItem = coinList, isLoading = isLoading)
                }
            }
        }
        val viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        viewModel.getList().observe(this, Observer { response ->
                when (response.status) {
                    ApiStatus.LOADING -> {
                        isLoading = true
                    }
                    ApiStatus.SUCCESSFULL -> {
                        response.data?.let {
                            coinList.clear()
                            coinList.addAll(it)
                            isLoading = false
                            Toast.makeText(this, "Coin List Successful", Toast.LENGTH_SHORT).show()
                        }
                    }
                    ApiStatus.ERROR -> {
                        isLoading = false
                        Toast.makeText(this, response.msg, Toast.LENGTH_LONG).show()
                    }
                }
        })
    }
}

@Composable
fun MainActivityToolbar(listResponseItem: MutableList<ListResponseItem>){
    Column {
        TopAppBar(title = { Text(text = stringResource(R.string.home_title)) }, backgroundColor = Purple700)
        HomeList(coinList = listResponseItem)
    }
}