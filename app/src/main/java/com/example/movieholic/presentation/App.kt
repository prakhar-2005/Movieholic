package com.example.movieholic.presentation

import android.app.Application
import com.example.movieholic.BuildConfig
import com.example.movieholic.presentation.dagger.Injector
import com.example.movieholic.presentation.dagger.artist.ArtistSubComponent
import com.example.movieholic.presentation.dagger.main.*
import com.example.movieholic.presentation.dagger.movie.MovieSubComponent
import com.example.movieholic.presentation.dagger.tvshow.TvShowSubComponent

class App: Application(),Injector {
    private lateinit var appComponent:AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .networkModule(NetworkModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubcomponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubcomponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubcomponent().create()
    }

}