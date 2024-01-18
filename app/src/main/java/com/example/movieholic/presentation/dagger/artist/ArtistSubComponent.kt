package com.example.movieholic.presentation.dagger.artist

import com.example.movieholic.presentation.artists.ArtistsActivity
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent { //subcomponent to inject dependencies to artist activity
    fun inject(artistsActivity: ArtistsActivity)

    @Subcomponent.Factory
    interface Factory{ //so AppComponent knows how to create instances of the subcomponent of Artist component
        fun create(): ArtistSubComponent
    }
}