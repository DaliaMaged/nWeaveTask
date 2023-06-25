package com.example.data.repoImplementation

import com.example.data.api.ApiService
import com.example.data.db.ProductsDao
import com.example.domain.entities.ProductModel
import com.example.domain.entities.Products
import com.example.domain.repos.ProductRepo

class ProductsImpl(private val api: ApiService, private val appDB: ProductsDao):ProductRepo {
    override suspend fun getProductsFromRemote(): Products = api.getProducts()
    override suspend fun getProductsFromLocal(): List<ProductModel> = appDB.getAllProducts()
    override suspend fun insertProductsToLocal(products: List<ProductModel>) =
        appDB.insertAllProducts(products)
    override suspend fun getProductsSize(): Int = appDB.getProductsSize()
}