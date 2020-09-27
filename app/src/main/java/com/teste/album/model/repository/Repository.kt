package com.teste.album.model.repository

import com.teste.album.di.RemoteDataSource
import com.teste.album.model.data.Album
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor() {

    @Inject
    @RemoteDataSource
    lateinit var remoteDataSource: AlbumDataSource

    suspend fun getAlbums(): Response<List<Album>> {
        return remoteDataSource.getAlbums()
    }
}