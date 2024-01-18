package com.example.movieholic.presentation.dagger.main

import com.example.movieholic.data.repository.movie.datasource.PopularMovieCacheDatasource
import com.example.movieholic.data.repository.movie.datasourceimpl.MovieCacheDatasourceImpl
import com.example.movieholic.data.repository.people.datasource.PopularPeopleCacheDatasource
import com.example.movieholic.data.repository.people.datasourceimpl.PeopleCacheDatasourceImpl
import com.example.movieholic.data.repository.tvseries.datasource.PopularTvSeriesCacheDatasource
import com.example.movieholic.data.repository.tvseries.datasourceimpl.TvSeriesCacheDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): PopularMovieCacheDatasource{
        return MovieCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvSeriesCacheDataSource(): PopularTvSeriesCacheDatasource{
        return TvSeriesCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun providePeopleCacheDataSource(): PopularPeopleCacheDatasource{
        return PeopleCacheDatasourceImpl()
    }
}