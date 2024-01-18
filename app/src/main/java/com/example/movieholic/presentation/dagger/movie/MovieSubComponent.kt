package com.example.movieholic.presentation.dagger.movie

import com.example.movieholic.presentation.movies.MoviesActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent { //subcomponent to inject dependencies to artist activity
    fun inject(moviesActivity: MoviesActivity)

    @Subcomponent.Factory
    interface Factory{ //so AppComponent knows how to create instances of the subcomponent of Artist component
        fun create(): MovieSubComponent
    }
}