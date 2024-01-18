package com.example.movieholic.presentation.dagger.main

import com.example.movieholic.data.api.TMDBService
import com.example.movieholic.data.repository.movie.datasource.PopularMovieRemoteDatasource
import com.example.movieholic.data.repository.movie.datasourceimpl.MovieRemoteDatasourceImpl
import com.example.movieholic.data.repository.people.datasource.PopularPeopleRemoteDatasource
import com.example.movieholic.data.repository.people.datasourceimpl.PeopleRemoteDatasourceImpl
import com.example.movieholic.data.repository.tvseries.datasource.PopularTvSeriesRemoteDatasource
import com.example.movieholic.data.repository.tvseries.datasourceimpl.TvSeriesRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey:String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): PopularMovieRemoteDatasource{
        return MovieRemoteDatasourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvRemoteDataSource(tmdbService: TMDBService): PopularTvSeriesRemoteDatasource{
        return TvSeriesRemoteDatasourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): PopularPeopleRemoteDatasource{
        return PeopleRemoteDatasourceImpl(
            tmdbService, apiKey
        )
    }
}