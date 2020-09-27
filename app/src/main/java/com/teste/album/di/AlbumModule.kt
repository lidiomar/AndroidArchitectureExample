package com.teste.album.di

import com.teste.album.model.repository.AlbumDataSource
import com.teste.album.model.repository.remote.AlbumRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
annotation class RemoteDataSource

@Module
@InstallIn(ApplicationComponent::class)
abstract class AlbumModule {
    @Singleton
    @Binds
    @RemoteDataSource
    abstract fun bindRemoteDataSource(impl: AlbumRemoteDataSource): AlbumDataSource
}