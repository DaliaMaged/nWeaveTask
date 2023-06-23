package com.example.domain.repos

import com.example.domain.entities.ProductResponse

interface ProductRepo {
    suspend fun getProductsFromRemote(): ProductResponse
    suspend fun getProductsFromLocal(): ProductResponse
}