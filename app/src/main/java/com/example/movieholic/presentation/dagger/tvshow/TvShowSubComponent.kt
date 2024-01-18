package com.example.movieholic.presentation.dagger.tvshow

import com.example.movieholic.presentation.tvshows.TvShowsActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent { //subcomponent to inject dependencies to artist activity
    fun inject(tvShowsActivity: TvShowsActivity)

    @Subcomponent.Factory
    interface Factory{ //so AppComponent knows how to create instances of the subcomponent of Artist component
        fun create(): TvShowSubComponent
    }
}