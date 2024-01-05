package com.example.movieholic.data.repository.tvseries.datasource

import com.example.movieholic.data.models.tvShows.PopularTvSeries

interface PopularTvSeriesCacheDatasource {
    suspend fun getPopularTvSeriesFromCache(): List<PopularTvSeries>
    suspend fun savePopularTvSeriesToCache(tvSeries: List<PopularTvSeries>)
}