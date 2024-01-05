package com.example.movieholic.domain.usecase

import com.example.movieholic.data.models.movies.PopularMovie
import com.example.movieholic.domain.repository.PopularMovieRepository

class UpdatePopularMoviesUseCase(private val popularMovieRepository: PopularMovieRepository) {
    suspend fun execute(): List<PopularMovie>? = popularMovieRepository.updatePopularMovies()
}