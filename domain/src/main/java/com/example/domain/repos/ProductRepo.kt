package com.example.domain.repos

import com.example.domain.entities.ProductModel
import com.example.domain.entities.Products

interface ProductRepo {
    suspend fun getProductsFromRemote(): Products
    suspend fun getProductsFromLocal(): List<ProductModel>
    suspend fun insertProductsToLocal(products:List<ProductModel>)
    suspend fun getProductsSize():Int
}