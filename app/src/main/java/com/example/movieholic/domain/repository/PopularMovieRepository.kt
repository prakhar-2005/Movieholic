package com.example.movieholic.domain.repository

import com.example.movieholic.data.models.movies.PopularMovie

interface PopularMovieRepository {
    suspend fun getPopularMovies(): List<PopularMovie>?
    suspend fun updatePopularMovies(): List<PopularMovie>?
}