package com.example.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductModel(
    @PrimaryKey
    val id: String,
    val name: String,
    val description: String,
    val price: String,
    val imageUrl: String
)
