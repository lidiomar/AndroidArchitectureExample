package com.teste.album.model.repository

import com.teste.album.model.data.Album
import retrofit2.Response

interface AlbumDataSource {
    suspend fun getAlbums(): Response<List<Album>>
}