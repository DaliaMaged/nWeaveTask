package com.example.data.repoImplementation

import com.example.data.api.ApiService
import com.example.data.db.AppDB
import com.example.domain.entities.Products
import com.example.domain.repos.ProductRepo

class ProductsImpl(private val api: ApiService, private val appDB: AppDB):ProductRepo {
    override suspend fun getProductsFromRemote(): Products = api.getProducts()
    override suspend fun getProductsFromLocal(): Products =appDB.productsDao().getAllProducts()
    override suspend fun insertProductsToLocal(products: Products) = appDB.productsDao().insertAllProducts(products)
}