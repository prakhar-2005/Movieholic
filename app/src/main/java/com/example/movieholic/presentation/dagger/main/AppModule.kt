package com.example.movieholic.presentation.dagger.main

import android.content.Context
import com.example.movieholic.presentation.dagger.artist.ArtistSubComponent
import com.example.movieholic.presentation.dagger.movie.MovieSubComponent
import com.example.movieholic.presentation.dagger.tvshow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class, TvShowSubComponent::class, ArtistSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideAppContext(): Context{
        return context.applicationContext
    }
}