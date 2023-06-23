package com.example.data.repoImplementation

import com.example.data.APIServices.ApiService
import com.example.domain.entities.ProductResponse
import com.example.domain.repos.ProductRepo

class ProductsImpl(private val api:ApiService):ProductRepo {
    override suspend fun getProductsFromRemote(): ProductResponse = api.getProducts()
    override suspend fun getProductsFromLocal(): ProductResponse {
        TODO("Not yet implemented")
    }
}