package com.example.movieholic.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieholic.data.models.tvShows.PopularTvSeries

@Dao
interface PopularTvSeriesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE) //to replace old data and continue transaction
    suspend fun savePopularTvSeries(tvSeries: List<PopularTvSeries>)

    @Query("DELETE FROM popular_tv_series")
    suspend fun deleteAllPopularTvSeries()

    @Query("SELECT * FROM popular_tv_series")
    suspend fun getAllPopularTvSeries(): List<PopularTvSeries>
}