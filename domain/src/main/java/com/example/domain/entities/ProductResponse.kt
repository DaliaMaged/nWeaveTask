package com.example.domain.entities

data class ProductResponse(
	val productResponse: List<ProductResponseItem?>? = null
)

data class Product(
	val price: String? = null,
	val imageUrl: String? = null,
	val name: String? = null,
	val description: String? = null,
	val id: String? = null,
	val productTypeId: Any? = null,
	val shoppingCartItemId: Any? = null,
	val unitPrice: Any? = null,
	val shoppingListItemId: Any? = null
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

data class ProductResponseItem(
	val product: Product? = null,
	val productMerchants: List<ProductMerchantsItem?>? = null
)

