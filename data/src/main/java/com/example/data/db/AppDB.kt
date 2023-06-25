package com.example.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.domain.entities.ProductModel

@Database(entities = [ProductModel::class] , version = 1, exportSchema = false)
abstract class AppDB : RoomDatabase() {
    abstract fun productsDao():ProductsDao
}