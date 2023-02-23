package com.example.productlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.productlist.dao.repository.ProductRepository
import com.example.productlist.model.Produto
import com.example.productlist.ui.card.DetailsContent
import com.example.productlist.ui.theme.ProductListTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {

    val repository: ProductRepository = ProductRepository(LocalContext.current)

    var productsList by remember {
        mutableStateOf(listOf<Produto>())
    }

    productsList = repository.getProductsList()

    var nameState by remember {
        mutableStateOf("")
    }

    var priceState by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        OutlinedTextField(value = nameState, onValueChange = { nameState = it }, label = {Text("Name")}, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = priceState, onValueChange = { priceState = it }, label = {Text("Price")}, modifier = Modifier.fillMaxWidth())

        Button(onClick = {
            repository.insertProduct(Produto(productName = nameState, productPrice = priceState.toDouble()))
            productsList = repository.getProductsList()
        }, modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Cadastrar")
        }

        DetailsContent(productsList)
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ProductListTheme {
        Greeting()
    }
}