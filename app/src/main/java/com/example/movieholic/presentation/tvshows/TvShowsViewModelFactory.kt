package com.example.movieholic.presentation.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieholic.domain.usecase.GetPopularTvSeriesUsecase
import com.example.movieholic.domain.usecase.UpdatePopularTvSeriesUsecase

class TvShowsViewModelFactory(
    private val getPopularTvSeriesUsecase: GetPopularTvSeriesUsecase,
    private val updatePopularTvSeriesUsecase: UpdatePopularTvSeriesUsecase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowsViewModel(getPopularTvSeriesUsecase, updatePopularTvSeriesUsecase) as T
    }
}