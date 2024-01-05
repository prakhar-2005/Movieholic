package com.example.movieholic.domain.usecase

import com.example.movieholic.data.models.tvShows.PopularTvSeries
import com.example.movieholic.domain.repository.PopularTvSeriesRepository

class GetPopularTvSeriesUsecase(private val popularTvSeriesRepository: PopularTvSeriesRepository) {
    suspend fun execute(): List<PopularTvSeries>? = popularTvSeriesRepository.getPopularTvSeries()
}