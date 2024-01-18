package com.example.movieholic.presentation.tvshows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieholic.R
import com.example.movieholic.data.models.tvShows.PopularTvSeries
import com.example.movieholic.databinding.ListItemBinding

class TvShowAdapter(): RecyclerView.Adapter<TvShowHolder>() {
    private val tvList = ArrayList<PopularTvSeries>()

    fun setTvList(tvSeries: List<PopularTvSeries>){
        tvList.clear()
        tvList.addAll(tvSeries)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )

        return TvShowHolder(binding)
    }

    override fun getItemCount(): Int {
        return tvList.size
    }

    override fun onBindViewHolder(holder: TvShowHolder, position: Int) {
        holder.bindData(tvList[position])
    }

}

class TvShowHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bindData(tvSeries: PopularTvSeries){
        binding.titleText.text = tvSeries.name
        binding.descriptionText.text = tvSeries.overview

        val posterUrl = "https://image.tmdb.org/t/p/w500" + tvSeries.posterPath
        Glide.with(binding.image.context)
            .load(posterUrl)
            .into(binding.image)
    }
}