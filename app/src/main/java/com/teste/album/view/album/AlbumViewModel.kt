package com.teste.album.view.album

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teste.album.model.repository.Repository
import com.teste.album.model.data.Album
import kotlinx.coroutines.launch
import retrofit2.Response

class AlbumViewModel @ViewModelInject constructor(
    private val repository: Repository): ViewModel() {

    private val _albums= MutableLiveData<Response<List<Album>>>()
    val albums: LiveData<Response<List<Album>>>
    get() = _albums

    fun getAlbums() {
        viewModelScope.launch {
            val albums = repository.getAlbums()
            _albums.postValue(albums)
        }
    }

}