package com.teste.album.di

import com.google.gson.GsonBuilder
import com.teste.album.model.repository.remote.RetrofitAlbums
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ServiceBuilder {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()

    @Provides
    fun providesAlbums(retrofit: Retrofit): RetrofitAlbums {
        return retrofit.create(RetrofitAlbums::class.java)
    }
}