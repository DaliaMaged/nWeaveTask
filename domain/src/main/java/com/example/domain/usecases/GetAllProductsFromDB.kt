package com.example.domain.usecases

import com.example.domain.entities.ProductModel
import com.example.domain.repos.ProductRepo

class AllProductsFromDB(private val productRepo: ProductRepo) {
    suspend fun getProductsFromLocal()= productRepo.getProductsFromLocal()
    suspend fun insertProductsToLocal(list:List<ProductModel>) = productRepo.insertProductsToLocal(list)
    suspend fun tableSize() = productRepo.getProductsSize()
}