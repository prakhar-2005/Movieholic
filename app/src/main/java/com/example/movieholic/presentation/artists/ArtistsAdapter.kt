package com.example.movieholic.presentation.artists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieholic.R
import com.example.movieholic.data.models.people.PopularPeople
import com.example.movieholic.databinding.ListItemBinding

class ArtistsAdapter(): RecyclerView.Adapter<ArtistViewHolder>() {
    private val artistList = ArrayList<PopularPeople>()

    fun setArtistList(artists: List<PopularPeople>){
        artistList.clear()
        artistList.addAll(artists)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )

        return ArtistViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return artistList.size
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bindData(artistList[position])
    }

}

class ArtistViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bindData(artist: PopularPeople){
        binding.titleText.text = artist.name
        binding.descriptionText.text = artist.popularity.toString()

        val posterUrl = "https://image.tmdb.org/t/p/w500" + artist.profilePath
        Glide.with(binding.image.context)
            .load(posterUrl)
            .into(binding.image)

    }
}