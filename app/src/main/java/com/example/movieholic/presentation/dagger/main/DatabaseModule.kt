package com.example.movieholic.presentation.dagger.main

import android.content.Context
import androidx.room.Room
import com.example.movieholic.data.db.PopularMovieDao
import com.example.movieholic.data.db.PopularPeopleDao
import com.example.movieholic.data.db.PopularTvSeriesDao
import com.example.movieholic.data.db.TMDBDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context): TMDBDatabase{
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "TMDBClient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): PopularMovieDao{
        return tmdbDatabase.popularMovieDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase): PopularTvSeriesDao{
        return tmdbDatabase.popularTvSeriesDao()
    }

    @Singleton
    @Provides
    fun providePeopleDao(tmdbDatabase: TMDBDatabase): PopularPeopleDao{
        return tmdbDatabase.popularPeopleDao()
    }
}