package com.example.movieholic.data.repository.tvseries.datasource

import com.example.movieholic.data.models.tvShows.PopularTvSeriesList
import retrofit2.Response

interface PopularTvSeriesRemoteDatasource {
    suspend fun getPopularTvSeries(): Response<PopularTvSeriesList>
}