package com.example.data.repoImplementation

import com.example.data.api.ApiService
import com.example.domain.entities.Products
import com.example.domain.repos.ProductRepo

class ProductsImpl(private val api: ApiService):ProductRepo {
    override suspend fun getProductsFromRemote(): Products = api.getProducts()
    override suspend fun getProductsFromLocal(): Products {
        TODO("Not yet implemented")
    }
}