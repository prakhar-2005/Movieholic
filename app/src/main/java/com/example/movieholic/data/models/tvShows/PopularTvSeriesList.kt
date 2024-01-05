package com.example.movieholic.data.models.tvShows


import com.google.gson.annotations.SerializedName

data class PopularTvSeriesList(
//    @SerializedName("page")
//    val page: Int,
    @SerializedName("results")
    val popularTvSeries: List<PopularTvSeries>
//    @SerializedName("total_pages")
//    val totalPages: Int,
//    @SerializedName("total_results")
//    val totalResults: Int
)