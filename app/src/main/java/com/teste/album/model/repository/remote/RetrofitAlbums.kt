package com.teste.album.model.remote

import com.teste.album.model.data.Album
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitAlbums {
    @GET("albums")
    suspend fun getAlbums(): Response<List<Album>>
}