package com.example.nweavetask.ui

import com.example.domain.entities.Product
import com.example.domain.entities.ProductModel
import com.example.domain.entities.ProductResponse
import com.example.domain.entities.Products

internal fun responseToModel(productResponse: ProductResponse):ProductModel{
    return ProductModel(
        id = productResponse.products.id,
        imageUrl = productResponse.products.imageUrl,
        description = productResponse.products.description,
        name = productResponse.products.name,
        price = productResponse.products.price
    )
}
fun mapProductModelListToProducts(productModelList: List<ProductModel>): Products {
    val productResponseList = productModelList.map { productModel ->
        ProductResponse(
            products = Product(
                id = productModel.id,
                name = productModel.name,
                description = productModel.description,
                price = productModel.price,
                imageUrl = productModel.imageUrl
            )
        )
    }
    return Products(productResponseList)
}
