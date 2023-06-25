package com.example.nweavetask.di

import android.content.Context
import androidx.room.Room
import com.example.data.db.AppDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {
    @Provides
    fun provideMyAppDatabase(@ApplicationContext context: Context): AppDB {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDB::class.java, "myapp_database"
        ).build()
    }
    @Provides
    @Singleton
    fun provideDao(db:AppDB) = db.productsDao()
}