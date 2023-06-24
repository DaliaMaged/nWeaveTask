package com.example.data.api

import com.example.domain.entities.Products
import retrofit2.http.GET

interface ApiService {
    @GET("featured.txt")
    suspend fun getProducts(): Products
}