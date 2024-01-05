package com.example.movieholic.data.repository.tvseries.datasource

import com.example.movieholic.data.models.tvShows.PopularTvSeries

interface PopularTvSeriesLocalDatasource {
    suspend fun getPopularTvSeriesFromDB(): List<PopularTvSeries>
    suspend fun savePopularTvSeriesToDB(tvSeries: List<PopularTvSeries>)
    suspend fun clearAll()
}