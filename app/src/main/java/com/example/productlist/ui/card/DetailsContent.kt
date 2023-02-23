package com.example.productlist.ui.card

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.example.productlist.dao.repository.ProductRepository
import com.example.productlist.model.Produto

@Composable
fun DetailsContent(list: List<Produto>) {
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)){
        items(list){ ProductCard(produto = it) }
    }
}
