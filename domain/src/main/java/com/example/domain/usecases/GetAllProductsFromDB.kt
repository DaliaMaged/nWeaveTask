package com.example.domain.usecases

import com.example.domain.entities.Products
import com.example.domain.repos.ProductRepo

class AllProductsFromDB(private val productRepo: ProductRepo) {
    suspend fun getProductsFromLocal()= productRepo.getProductsFromLocal()
    suspend fun insertProductsToLocal(list:Products) = productRepo.insertProductsToLocal(list)
}