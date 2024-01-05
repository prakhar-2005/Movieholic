package com.example.movieholic.data.repository.movie.datasourceimpl

import com.example.movieholic.data.api.TMDBService
import com.example.movieholic.data.models.movies.PopularMovieList
import com.example.movieholic.data.repository.movie.datasource.PopularMovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDatasourceImpl(private val tmdbService: TMDBService, private val apiKey:String):
    PopularMovieRemoteDatasource {
    override suspend fun getPopularMovies(): Response<PopularMovieList> = tmdbService.getPopularMovies(apiKey)
}