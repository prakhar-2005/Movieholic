package com.example.movieholic.data.repository.movie

import android.util.Log
import com.example.movieholic.data.models.movies.PopularMovie
import com.example.movieholic.data.repository.movie.datasource.PopularMovieCacheDatasource
import com.example.movieholic.data.repository.movie.datasource.PopularMovieLocalDatasource
import com.example.movieholic.data.repository.movie.datasource.PopularMovieRemoteDatasource
import com.example.movieholic.domain.repository.PopularMovieRepository

class PopularMovieRepoImpl(
    private val movieRemoteDatasource: PopularMovieRemoteDatasource,
    private val movieLocalDatasource: PopularMovieLocalDatasource,
    private val movieCacheDatasource: PopularMovieCacheDatasource
): PopularMovieRepository {
    override suspend fun getPopularMovies(): List<PopularMovie>? {
        return getMoviesFromCache()

    }

    override suspend fun updatePopularMovies(): List<PopularMovie>? {
        val newMovieList = getMoviesFromApi()
        movieLocalDatasource.clearAll()
        movieLocalDatasource.savePopularMoviesToDB(newMovieList)
        movieCacheDatasource.savePopularMoviesToCache(newMovieList)

        return newMovieList
    }

    suspend fun getMoviesFromApi():List<PopularMovie>{
        lateinit var movieList: List<PopularMovie>

        //exception handling
        try{
            val response = movieRemoteDatasource.getPopularMovies()
            val body = response.body()
            if(body!=null){
                movieList = body.popularmovies
            }
        }catch(exception: Exception){
            Log.i("MYTAG", exception.message.toString())
        }

        return movieList
    }

    suspend fun getMoviesFromDB(): List<PopularMovie>{
        lateinit var movieList: List<PopularMovie>

        try {
            movieList = movieLocalDatasource.getPopularMoviesFromDB()

        }catch(exception: Exception){
            Log.i("MYTAG", exception.message.toString())
        }

        if(movieList.size>0){
            return movieList
        }else{
            movieList=getMoviesFromApi()
            movieLocalDatasource.savePopularMoviesToDB(movieList)
        }

        return movieList
    }

    suspend fun getMoviesFromCache(): List<PopularMovie>{
        lateinit var movieList: List<PopularMovie>

        try {
            movieList = movieCacheDatasource.getPopularMoviesFromCache()
        }catch(exception: Exception){
            Log.i("MYTAG", exception.message.toString())
        }

        if(movieList.size>0){
            return movieList
        }else{
            movieList = getMoviesFromDB()
            movieCacheDatasource.savePopularMoviesToCache(movieList)
        }

        return movieList
    }

}