package com.example.movieholic.presentation.dagger.main

import com.example.movieholic.data.db.PopularMovieDao
import com.example.movieholic.data.db.PopularPeopleDao
import com.example.movieholic.data.db.PopularTvSeriesDao
import com.example.movieholic.data.repository.movie.datasource.PopularMovieLocalDatasource
import com.example.movieholic.data.repository.movie.datasourceimpl.MovieLocalDatasourceImpl
import com.example.movieholic.data.repository.people.datasource.PopularPeopleLocalDatasource
import com.example.movieholic.data.repository.people.datasourceimpl.PeopleLocalDatasourceImpl
import com.example.movieholic.data.repository.tvseries.datasource.PopularTvSeriesLocalDatasource
import com.example.movieholic.data.repository.tvseries.datasourceimpl.TvSeriesLocalDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: PopularMovieDao): PopularMovieLocalDatasource{
        return MovieLocalDatasourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvSeriesLocalDataSource(tvSeriesDao: PopularTvSeriesDao): PopularTvSeriesLocalDatasource{
        return TvSeriesLocalDatasourceImpl(tvSeriesDao)
    }

    @Singleton
    @Provides
    fun providePeopleLocalDataSource(peopleDao: PopularPeopleDao): PopularPeopleLocalDatasource{
        return PeopleLocalDatasourceImpl(peopleDao)
    }

}