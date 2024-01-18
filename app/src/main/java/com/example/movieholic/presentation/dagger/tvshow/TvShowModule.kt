package com.example.movieholic.presentation.dagger.tvshow

import com.example.movieholic.domain.usecase.GetPopularTvSeriesUsecase
import com.example.movieholic.domain.usecase.UpdatePopularTvSeriesUsecase
import com.example.movieholic.presentation.tvshows.TvShowsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvViewModelFactory(
        getPopularTvSeriesUsecase: GetPopularTvSeriesUsecase,
        updatePopularTvSeriesUsecase: UpdatePopularTvSeriesUsecase
    ): TvShowsViewModelFactory{
        return TvShowsViewModelFactory(getPopularTvSeriesUsecase, updatePopularTvSeriesUsecase)
    }
}