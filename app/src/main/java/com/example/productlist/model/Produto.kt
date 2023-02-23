package com.example.productlist.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_product")
data class Produto (
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "name") var productName: String = "Product's name",
    @ColumnInfo(name = "price") var productPrice: Double = 0.0,
    @ColumnInfo(name = "description") var productDescription: String = "Product's description"
)