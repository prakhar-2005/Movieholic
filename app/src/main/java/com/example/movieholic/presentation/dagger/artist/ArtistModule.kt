package com.example.movieholic.presentation.dagger.artist

import com.example.movieholic.domain.usecase.GetPopularPeopleUsecase
import com.example.movieholic.domain.usecase.UpdatePopularPeopleUsecase
import com.example.movieholic.presentation.artists.ArtistsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getPopularPeopleUsecase: GetPopularPeopleUsecase,
        updatePopularPeopleUsecase: UpdatePopularPeopleUsecase
    ): ArtistsViewModelFactory{
        return ArtistsViewModelFactory(getPopularPeopleUsecase, updatePopularPeopleUsecase)
    }
}