package com.example.movieholic.presentation.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieholic.domain.usecase.GetPopularPeopleUsecase
import com.example.movieholic.domain.usecase.UpdatePopularPeopleUsecase

class ArtistsViewModelFactory(
    private val getPopularPeopleUsecase: GetPopularPeopleUsecase,
    private val updatePopularPeopleUsecase: UpdatePopularPeopleUsecase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistsViewModel(getPopularPeopleUsecase, updatePopularPeopleUsecase) as T
    }

}