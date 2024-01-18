package com.example.movieholic.data.repository.movie.datasourceimpl

import com.example.movieholic.data.db.PopularMovieDao
import com.example.movieholic.data.models.movies.PopularMovie
import com.example.movieholic.data.repository.movie.datasource.PopularMovieLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDatasourceImpl(private val movieDao: PopularMovieDao): PopularMovieLocalDatasource {
    override suspend fun getPopularMoviesFromDB(): List<PopularMovie> {
        return  movieDao.getAllPopularMovies()
        //fetching data from room db, query will automatically be executed in background thread
        //room lib executes GET requests in background thread
    }

    override suspend fun savePopularMoviesToDB(movies: List<PopularMovie>) {
        CoroutineScope(Dispatchers.IO).launch{
            movieDao.savePopularMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch{
            movieDao.deleteAllPopularMovies()
        }
    }

}