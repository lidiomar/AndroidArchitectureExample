package com.teste.album.view.album

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.teste.album.R

class AlbumFragment: Fragment() {

    private val viewModel: AlbumViewModel by viewModels()
    private lateinit var textviewAlbums: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_album, container,false)
        textviewAlbums = view.findViewById(R.id.textview_albums)
        return view
    }

    override fun onResume() {
        super.onResume()
        viewModel.albums.observe(viewLifecycleOwner) { albumsResponse ->
            if(albumsResponse.isSuccessful) {
                val albums = albumsResponse.body()
                var albumsString = ""
                albums?.forEach { album ->  albumsString+= "${album.title} \n\n"}
                textviewAlbums.text = albumsString
            } else {
                textviewAlbums.text = "Error :("
            }
        }
        viewModel.getAlbums()
    }
}