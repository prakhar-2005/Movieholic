package com.example.movieholic.presentation.dagger

import com.example.movieholic.presentation.dagger.artist.ArtistSubComponent
import com.example.movieholic.presentation.dagger.movie.MovieSubComponent
import com.example.movieholic.presentation.dagger.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}