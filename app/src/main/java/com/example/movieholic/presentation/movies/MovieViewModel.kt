package com.example.movieholic.presentation.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movieholic.domain.usecase.GetPopularMoviesUseCase
import com.example.movieholic.domain.usecase.UpdatePopularMoviesUseCase

class MovieViewModel(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val updatePopularMoviesUseCase: UpdatePopularMoviesUseCase
): ViewModel() {

    fun getMovies() = liveData{
        val moviesList = getPopularMoviesUseCase.execute()
        emit(moviesList)
    }

    fun updateMovies() = liveData{
        val updatedMoviesList = updatePopularMoviesUseCase.execute()
        emit(updatedMoviesList)
    }
}