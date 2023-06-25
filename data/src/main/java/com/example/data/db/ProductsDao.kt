package com.example.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.domain.entities.ProductModel

@Dao
interface ProductsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllProducts(productsList:List<ProductModel>)
    @Query ("Select * FROM products")
    suspend fun getAllProducts():List<ProductModel>
    @Query("SELECT COUNT (*) FROM products")
    suspend fun getProductsSize():Int
}