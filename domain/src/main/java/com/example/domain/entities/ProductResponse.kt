package com.example.domain.entities

import com.google.gson.annotations.SerializedName

typealias Products = ArrayList<ProductResponse>

data class ProductResponse(
	@SerializedName("Product")
    var products: Product
	)
data class Product(
	@SerializedName("id")
	val id: String,
	@SerializedName("name")
	val name: String,
	@SerializedName("description")
	val description: String,
	@SerializedName("price")
	val price: String,
	@SerializedName("image_url")
	val imageUrl : String
)


