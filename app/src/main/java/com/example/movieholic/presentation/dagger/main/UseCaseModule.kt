package com.example.movieholic.presentation.dagger.main

import com.example.movieholic.domain.repository.PopularMovieRepository
import com.example.movieholic.domain.repository.PopularPeopleRepository
import com.example.movieholic.domain.repository.PopularTvSeriesRepository
import com.example.movieholic.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: PopularMovieRepository):GetPopularMoviesUseCase{
        return GetPopularMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: PopularMovieRepository): UpdatePopularMoviesUseCase{
        return UpdatePopularMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetTvUseCase(tvSeriesRepository: PopularTvSeriesRepository):GetPopularTvSeriesUsecase{
        return GetPopularTvSeriesUsecase(tvSeriesRepository)
    }

    @Provides
    fun provideUpdateTvUseCase(tvSeriesRepository: PopularTvSeriesRepository): UpdatePopularTvSeriesUsecase{
        return UpdatePopularTvSeriesUsecase(tvSeriesRepository)
    }

    @Provides
    fun provideGetPeopleUseCase(peopleRepository: PopularPeopleRepository): GetPopularPeopleUsecase{
        return GetPopularPeopleUsecase(peopleRepository)
    }

    @Provides
    fun provideUpdatePeopleUseCase(peopleRepository: PopularPeopleRepository): UpdatePopularPeopleUsecase{
        return UpdatePopularPeopleUsecase(peopleRepository)
    }
}