package com.example.domain.usecases

import com.example.domain.repos.ProductRepo

class GetAllProductsUseCase(private val productRepo: ProductRepo) {
   suspend operator fun invoke()=productRepo.getProductsFromRemote()
}