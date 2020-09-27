package com.teste.album.model.repository.remote

import com.teste.album.model.data.Album
import com.teste.album.model.repository.AlbumDataSource
import retrofit2.Response
import javax.inject.Inject

class AlbumRemoteDataSource @Inject constructor(private val retrofitAlbums: RetrofitAlbums): AlbumDataSource {
    override suspend fun getAlbums(): Response<List<Album>> {
        return retrofitAlbums.getAlbums()
    }
}