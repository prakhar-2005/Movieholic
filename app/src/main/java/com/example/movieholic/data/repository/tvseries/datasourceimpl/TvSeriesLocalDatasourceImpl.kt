package com.example.movieholic.data.repository.tvseries.datasourceimpl

import com.example.movieholic.data.db.PopularTvSeriesDao
import com.example.movieholic.data.models.tvShows.PopularTvSeries
import com.example.movieholic.data.repository.tvseries.datasource.PopularTvSeriesLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvSeriesLocalDatasourceImpl(private val tvSeriesDao: PopularTvSeriesDao): PopularTvSeriesLocalDatasource {
    override suspend fun getPopularTvSeriesFromDB(): List<PopularTvSeries> {
        return tvSeriesDao.getAllPopularTvSeries()
    }

    override suspend fun savePopularTvSeriesToDB(tvSeries: List<PopularTvSeries>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvSeriesDao.savePopularTvSeries(tvSeries)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvSeriesDao.deleteAllPopularTvSeries()
        }
    }
}