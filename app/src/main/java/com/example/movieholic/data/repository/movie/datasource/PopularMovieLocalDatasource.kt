package com.example.movieholic.data.repository.movie.datasource

import com.example.movieholic.data.models.movies.PopularMovie

interface PopularMovieLocalDatasource {
    suspend fun getPopularMoviesFromDB(): List<PopularMovie>
    suspend fun savePopularMoviesToDB(movies: List<PopularMovie>)
    suspend fun clearAll()
}