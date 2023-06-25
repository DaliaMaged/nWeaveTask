package com.example.nweavetask.di

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.db.AppDB
import com.example.data.db.AppDbManager
import com.example.data.db.ProductsDao
import com.example.domain.entities.ProductResponse
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(Application::class)
object DbModule {
//    @Singleton
//    @Database(entities = [ProductResponse::class] , version = 1, exportSchema = false)
//    abstract class AppDB : RoomDatabase() {
//        abstract fun productsDao(): ProductsDao
//    }
    @Provides
    fun provideMyAppDatabase(@ApplicationContext context: Context): AppDB {
        return Room.databaseBuilder(
            context,
            AppDB::class.java, "myapp_database"
        ).build()
    }
}