package com.example.movieholic.presentation.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieholic.domain.usecase.GetPopularMoviesUseCase
import com.example.movieholic.domain.usecase.UpdatePopularMoviesUseCase

class MovieViewModelFactory(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val updatePopularMoviesUseCase: UpdatePopularMoviesUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getPopularMoviesUseCase, updatePopularMoviesUseCase) as T
    }
}