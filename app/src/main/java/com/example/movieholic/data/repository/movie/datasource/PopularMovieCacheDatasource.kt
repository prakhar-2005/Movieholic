package com.example.movieholic.data.repository.movie.datasource

import com.example.movieholic.data.models.movies.PopularMovie

interface PopularMovieCacheDatasource {
    suspend fun getPopularMoviesFromCache(): List<PopularMovie>
    suspend fun savePopularMoviesToCache(movies: List<PopularMovie>)
}