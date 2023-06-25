package com.example.domain.repos

import com.example.domain.entities.Products

interface ProductRepo {
    suspend fun getProductsFromRemote(): Products
    suspend fun getProductsFromLocal(): Products
    suspend fun insertProductsToLocal(products:Products)
}