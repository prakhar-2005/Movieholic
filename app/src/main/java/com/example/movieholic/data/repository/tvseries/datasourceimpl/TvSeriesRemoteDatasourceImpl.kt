package com.example.movieholic.data.repository.tvseries.datasourceimpl

import com.example.movieholic.data.api.TMDBService
import com.example.movieholic.data.models.tvShows.PopularTvSeriesList
import com.example.movieholic.data.repository.tvseries.datasource.PopularTvSeriesRemoteDatasource
import retrofit2.Response

class TvSeriesRemoteDatasourceImpl(private val tmdbService: TMDBService, private val apiKey: String): PopularTvSeriesRemoteDatasource {
    override suspend fun getPopularTvSeries(): Response<PopularTvSeriesList> = tmdbService.getPopularTvSeries(apiKey)
}