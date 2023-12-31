package com.example.nweavetask.di

import com.example.domain.repos.ProductRepo
import com.example.domain.usecases.AllProductsFromDB
import com.example.domain.usecases.GetAllProductsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideProductsRemote(repo: ProductRepo) : GetAllProductsUseCase{
        return GetAllProductsUseCase(repo)
    }
    @Provides
    fun provideProductsLocal(repo: ProductRepo) : AllProductsFromDB{
        return AllProductsFromDB(repo)
    }
}