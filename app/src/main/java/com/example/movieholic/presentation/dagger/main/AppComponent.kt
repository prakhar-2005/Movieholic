package com.example.movieholic.presentation.dagger.main

import com.example.movieholic.presentation.dagger.artist.ArtistSubComponent
import com.example.movieholic.presentation.dagger.movie.MovieSubComponent
import com.example.movieholic.presentation.dagger.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetworkModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class,
    RepositoryModule::class,
    UseCaseModule::class,
    DatabaseModule::class
])
interface AppComponent {
    fun movieSubcomponent(): MovieSubComponent.Factory
    fun tvShowSubcomponent(): TvShowSubComponent.Factory
    fun artistSubcomponent(): ArtistSubComponent.Factory
}