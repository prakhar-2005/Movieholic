package com.example.movieholic.presentation.dagger.main

import com.example.movieholic.data.repository.movie.PopularMovieRepoImpl
import com.example.movieholic.data.repository.movie.datasource.PopularMovieCacheDatasource
import com.example.movieholic.data.repository.movie.datasource.PopularMovieLocalDatasource
import com.example.movieholic.data.repository.movie.datasource.PopularMovieRemoteDatasource
import com.example.movieholic.data.repository.people.PopularPeopleRepoImpl
import com.example.movieholic.data.repository.people.datasource.PopularPeopleCacheDatasource
import com.example.movieholic.data.repository.people.datasource.PopularPeopleLocalDatasource
import com.example.movieholic.data.repository.people.datasource.PopularPeopleRemoteDatasource
import com.example.movieholic.data.repository.tvseries.PopularTvSeriesRepoImpl
import com.example.movieholic.data.repository.tvseries.datasource.PopularTvSeriesCacheDatasource
import com.example.movieholic.data.repository.tvseries.datasource.PopularTvSeriesLocalDatasource
import com.example.movieholic.data.repository.tvseries.datasource.PopularTvSeriesRemoteDatasource
import com.example.movieholic.domain.repository.PopularMovieRepository
import com.example.movieholic.domain.repository.PopularPeopleRepository
import com.example.movieholic.domain.repository.PopularTvSeriesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDatasource: PopularMovieRemoteDatasource,
        movieLocalDatasource: PopularMovieLocalDatasource,
        movieCacheDatasource: PopularMovieCacheDatasource
    ): PopularMovieRepository{

        return PopularMovieRepoImpl(movieRemoteDatasource,movieLocalDatasource,movieCacheDatasource)
    }

    @Singleton
    @Provides
    fun provideTvSeriesRepository(
        tvSeriesRemoteDatasource: PopularTvSeriesRemoteDatasource,
        tvSeriesLocalDatasource: PopularTvSeriesLocalDatasource,
        tvSeriesCacheDatasource: PopularTvSeriesCacheDatasource
    ): PopularTvSeriesRepository{

        return PopularTvSeriesRepoImpl(tvSeriesRemoteDatasource,tvSeriesLocalDatasource,tvSeriesCacheDatasource)
    }

    @Singleton
    @Provides
    fun providePeopleRepository(
        peopleRemoteDatasource: PopularPeopleRemoteDatasource,
        peopleLocalDatasource: PopularPeopleLocalDatasource,
        peopleCacheDatasource: PopularPeopleCacheDatasource
    ): PopularPeopleRepository{

        return PopularPeopleRepoImpl(peopleRemoteDatasource, peopleLocalDatasource, peopleCacheDatasource)
    }
}