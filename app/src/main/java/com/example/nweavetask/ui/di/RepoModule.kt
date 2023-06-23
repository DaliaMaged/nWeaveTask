package com.example.nweavetask.ui.di

import com.example.data.APIServices.ApiService
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