package com.example.movieholic.data.api

import com.example.movieholic.data.models.movies.PopularMovieList
import com.example.movieholic.data.models.people.PopularPeopleList
import com.example.movieholic.data.models.tvShows.PopularTvSeriesList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") api_key:String): Response<PopularMovieList>

    @GET("person/popular")
    suspend fun getPopularPeople(@Query("api_key") api_key:String): Response<PopularPeopleList>

    @GET("tv/popular")
    suspend fun getPopularTvSeries(@Query("api_key") api_key:String): Response<PopularTvSeriesList>
}