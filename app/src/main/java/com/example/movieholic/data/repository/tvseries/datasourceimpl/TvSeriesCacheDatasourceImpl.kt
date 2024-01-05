package com.example.movieholic.data.repository.tvseries.datasourceimpl

import com.example.movieholic.data.models.tvShows.PopularTvSeries
import com.example.movieholic.data.repository.tvseries.datasource.PopularTvSeriesCacheDatasource

class TvSeriesCacheDatasourceImpl: PopularTvSeriesCacheDatasource {
    private var tvSeriesList = ArrayList<PopularTvSeries>()
    override suspend fun getPopularTvSeriesFromCache(): List<PopularTvSeries> {
        return tvSeriesList
    }

    override suspend fun savePopularTvSeriesToCache(tvSeries: List<PopularTvSeries>) {
        tvSeriesList.clear()
        tvSeriesList = ArrayList(tvSeries)
    }
}