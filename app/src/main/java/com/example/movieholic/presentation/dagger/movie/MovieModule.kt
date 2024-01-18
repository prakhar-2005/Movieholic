package com.example.movieholic.presentation.dagger.movie

import com.example.movieholic.domain.usecase.GetPopularMoviesUseCase
import com.example.movieholic.domain.usecase.UpdatePopularMoviesUseCase
import com.example.movieholic.presentation.movies.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getPopularMoviesUseCase: GetPopularMoviesUseCase,
        updatePopularMoviesUseCase: UpdatePopularMoviesUseCase
    ): MovieViewModelFactory{
        return MovieViewModelFactory(getPopularMoviesUseCase, updatePopularMoviesUseCase)
    }
}