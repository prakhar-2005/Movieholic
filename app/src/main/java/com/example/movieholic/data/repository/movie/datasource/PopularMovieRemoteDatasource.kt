package com.example.movieholic.data.repository.movie.datasource

import com.example.movieholic.data.models.movies.PopularMovieList
import retrofit2.Response

interface PopularMovieRemoteDatasource {
    suspend fun getPopularMovies(): Response<PopularMovieList>
}