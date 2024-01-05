package com.example.movieholic.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieholic.data.models.movies.PopularMovie

@Dao
interface PopularMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) //to replace old data and continue transaction
    suspend fun savePopularMovies(movies: List<PopularMovie>)

    @Query("DELETE FROM popular_movies")
    suspend fun deleteAllPopularMovies()

    @Query("SELECT * FROM popular_movies")
    suspend fun getAllPopularMovies(): List<PopularMovie>
}