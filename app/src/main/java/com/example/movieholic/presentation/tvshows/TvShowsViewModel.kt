package com.example.movieholic.presentation.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movieholic.domain.usecase.GetPopularTvSeriesUsecase
import com.example.movieholic.domain.usecase.UpdatePopularTvSeriesUsecase

class TvShowsViewModel(
    private val getPopularTvSeriesUsecase: GetPopularTvSeriesUsecase,
    private val updatePopularTvSeriesUsecase: UpdatePopularTvSeriesUsecase
): ViewModel() {

    fun getTvShows() = liveData{
        val tvShowsList = getPopularTvSeriesUsecase.execute()
        emit(tvShowsList)
    }

    fun updateTvShows() = liveData{
        val updatedTvShowsList = updatePopularTvSeriesUsecase.execute()
        emit(updatedTvShowsList)
    }
}