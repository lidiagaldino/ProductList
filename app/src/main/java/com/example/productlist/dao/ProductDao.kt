package com.example.productlist.dao

import androidx.room.*
import com.example.productlist.model.Produto

@Dao
interface ProductDao {

    @Insert
    fun save(product: Produto): Long

    @Query("SELECT * FROM tbl_product ORDER BY name ASC")
    fun getProducts(): List<Produto>

    @Update
    fun update(product: Produto): Int

    @Delete
    fun delete(product: Produto): Int
}