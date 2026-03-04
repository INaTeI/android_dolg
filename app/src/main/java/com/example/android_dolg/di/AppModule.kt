package com.example.android_dolg.di

import com.example.android_dolg.data.GhibliApi
import com.example.android_dolg.data.PeopleRepositoryImpl
import com.example.android_dolg.domain.PeopleRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindRepository(
        impl: PeopleRepositoryImpl
    ): PeopleRepository
}

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://ghibli-api.vercel.app/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): GhibliApi =
        retrofit.create(GhibliApi::class.java)
}