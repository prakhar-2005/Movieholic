package com.example.movieholic.data.models.tvShows


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity("popular_tv_series")
data class PopularTvSeries(
//    @SerializedName("adult")
//    val adult: Boolean,
//    @SerializedName("backdrop_path")
//    val backdropPath: String,
    @SerializedName("first_air_date")
    val firstAirDate: String?,
//    @SerializedName("genre_ids")
//    val genreIds: List<Int>,
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String?,
//    @SerializedName("origin_country")
//    val originCountry: List<String>,
//    @SerializedName("original_language")
//    val originalLanguage: String,
//    @SerializedName("original_name")
//    val originalName: String,
    @SerializedName("overview")
    val overview: String?,
//    @SerializedName("popularity")
//    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String?
//    @SerializedName("vote_average")
//    val voteAverage: Double,
//    @SerializedName("vote_count")
//    val voteCount: Int
)