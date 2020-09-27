package com.teste.album.view.album

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.teste.album.R
import com.teste.album.databinding.FragmentAlbumBinding

class AlbumFragment: Fragment() {

    private val viewModel: AlbumViewModel by viewModels()
    private lateinit var bind: FragmentAlbumBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = DataBindingUtil.inflate(inflater, R.layout.fragment_album, container, false)

        return bind.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.albums.observe(viewLifecycleOwner) { albumsResponse ->
            if(albumsResponse.isSuccessful) {
                val albums = albumsResponse.body()
                var albumsString = ""
                albums?.forEach { album ->  albumsString+= "${album.title} \n\n"}
                bind.textviewAlbums.text = albumsString
            } else {
                bind.textviewAlbums.text = "Error :("
            }
        }
        viewModel.getAlbums()
    }
}