package com.example.nweavetask.di

import android.util.Log
import com.example.data.api.ApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }
    @Provides
    @Singleton
    fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        Log.e("TAG", "httpLoggingInterceptor: ", )
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    @Provides
    @Singleton
    fun provideHttp():OkHttpClient{
        return OkHttpClient.Builder()
            .connectTimeout(20,TimeUnit.SECONDS)
            .readTimeout(20,TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor())
            .build()
    }
    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://www.nweave.com/wp-content/uploads/2012/09/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(provideGson()))
            .build()
    }
    @Singleton
    @Provides
    fun provideApiServices(retrofit: Retrofit) : ApiService{
        httpLoggingInterceptor()
        return retrofit.create(ApiService::class.java)
    }
}