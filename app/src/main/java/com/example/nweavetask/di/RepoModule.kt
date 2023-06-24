package com.example.nweavetask.di

import com.example.data.api.ApiService
import com.example.data.repoImplementation.ProductsImpl
import com.example.domain.repos.ProductRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    fun providesApi(apiService: ApiService) : ProductRepo{
        return ProductsImpl(apiService)
    }
}