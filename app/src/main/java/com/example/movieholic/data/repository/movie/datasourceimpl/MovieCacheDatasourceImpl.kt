package com.example.movieholic.data.repository.movie.datasourceimpl

import com.example.movieholic.data.models.movies.PopularMovie
import com.example.movieholic.data.repository.movie.datasource.PopularMovieCacheDatasource

class MovieCacheDatasourceImpl: PopularMovieCacheDatasource {
    private var movieList = ArrayList<PopularMovie>()
    override suspend fun getPopularMoviesFromCache(): List<PopularMovie> {
        return movieList
    }

    override suspend fun savePopularMoviesToCache(movies: List<PopularMovie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}