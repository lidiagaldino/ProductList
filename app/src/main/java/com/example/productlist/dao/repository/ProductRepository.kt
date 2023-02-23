package com.example.productlist.dao.repository

import android.content.Context
import com.example.productlist.dao.ProductDb
import com.example.productlist.model.Produto

class ProductRepository(context: Context) {

    private val db = ProductDb.getDatabase(context).productDao()

    fun getProductsList(): List<Produto>{
        return db.getProducts()
    }

    fun insertProduct(product: Produto): Long{
        return db.save(product)
    }

    fun updateProduct(product: Produto): Int{
        return db.update(product)
    }

    fun delete(product: Produto): Int{
        return db.delete(product)
    }
}