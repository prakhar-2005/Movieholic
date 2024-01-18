package com.example.movieholic.presentation.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movieholic.domain.usecase.GetPopularPeopleUsecase
import com.example.movieholic.domain.usecase.UpdatePopularPeopleUsecase

class ArtistsViewModel(
    private val getPopularPeopleUsecase: GetPopularPeopleUsecase,
    private val updatePopularPeopleUsecase: UpdatePopularPeopleUsecase
): ViewModel() {

    fun getArtists() = liveData{
        val artistsList = getPopularPeopleUsecase.execute()
        emit(artistsList)
    }

    fun updateArtists() = liveData{
        val updatedArtistsList = updatePopularPeopleUsecase.execute()
        emit(updatedArtistsList)
    }
}