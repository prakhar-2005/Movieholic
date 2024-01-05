package com.example.movieholic.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movieholic.data.models.movies.PopularMovie
import com.example.movieholic.data.models.people.PopularPeople
import com.example.movieholic.data.models.tvShows.PopularTvSeries

@Database(entities = [PopularMovie::class, PopularTvSeries::class, PopularPeople::class],
    version = 1,
    exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {

    abstract fun popularMovieDao(): PopularMovieDao
    abstract fun popularTvSeriesDao(): PopularTvSeriesDao
    abstract fun popularPeopleDao(): PopularPeopleDao
}