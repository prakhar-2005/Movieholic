package com.example.movieholic.data.models.movies


import com.google.gson.annotations.SerializedName

data class PopularMovieList(
//    @SerializedName("page")
//    val page: Int,
    @SerializedName("results")
    val popularmovies: List<PopularMovie>
//    @SerializedName("total_pages")
//    val totalPages: Int,
//    @SerializedName("total_results")
//    val totalResults: Int
)