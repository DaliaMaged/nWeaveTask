package com.example.domain.entities

import com.google.gson.annotations.SerializedName

typealias Products = ArrayList<ProductResponse>

data class ProductResponse(
	@SerializedName("Product")
	val products: Product,
	val productMerchants: List<ProductMerchantsItem?>? = null
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

data class ProductMerchant(
	val multipleProductsPerPage: String? = null,
	val created: String? = null,
	val productId: String? = null,
	val upc: String? = null,
	val modified: String? = null,
	val id: String? = null,
	val sku: String? = null
)

data class Merchant(
	val name: String? = null,
	val id: String? = null
)

data class MerchantProduct(
	val price: String? = null,
	val upc: String? = null,
	val buyUrl: String? = null,
	val id: String? = null,
	val sku: String? = null,
	val discountPercent: String? = null,
	val unitPrice: Any? = null
)

data class ProductMerchantsItem(
	val productMerchant: ProductMerchant? = null,
	val merchant: Merchant? = null,
	val merchantProduct: MerchantProduct? = null
)

