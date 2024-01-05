package com.example.movieholic.domain.repository

import com.example.movieholic.data.models.tvShows.PopularTvSeries

interface PopularTvSeriesRepository {
    suspend fun getPopularTvSeries(): List<PopularTvSeries>?
    suspend fun updatePopularTvSeries(): List<PopularTvSeries>?
}