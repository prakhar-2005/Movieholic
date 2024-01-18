package com.example.movieholic.presentation.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieholic.R
import com.example.movieholic.data.models.movies.PopularMovie
import com.example.movieholic.databinding.ListItemBinding

class MoviesAdapter(): RecyclerView.Adapter<MovieViewHolder>() {
    private val movieList = ArrayList<PopularMovie>()

    fun setMovieList(movies: List<PopularMovie>){
        movieList.clear()
        movieList.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )

        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindData(movieList[position])
    }

}

class MovieViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bindData(movie: PopularMovie){
        binding.titleText.text = movie.title
        binding.descriptionText.text = movie.overview

        val posterUrl = "https://image.tmdb.org/t/p/w500" + movie.posterPath
        Glide.with(binding.image.context)
            .load(posterUrl)
            .into(binding.image)

    }
}