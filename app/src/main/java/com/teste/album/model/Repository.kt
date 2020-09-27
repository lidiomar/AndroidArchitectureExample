package com.teste.album.model

import com.teste.album.model.data.Album
import com.teste.album.model.remote.RetrofitAlbums
import com.teste.album.model.remote.ServiceBuilder
import retrofit2.Response

class Repository {
    private val service = ServiceBuilder.buildService(RetrofitAlbums::class.java)

    suspend fun getAlbums(): Response<List<Album>> {
        return service.getAlbums()
    }
}