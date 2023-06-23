package com.example.data.APIServices

import com.example.domain.entities.ProductResponse
import retrofit2.http.GET

interface ApiService {
    @GET("featured.txt")
    suspend fun getProducts(): ProductResponse
}