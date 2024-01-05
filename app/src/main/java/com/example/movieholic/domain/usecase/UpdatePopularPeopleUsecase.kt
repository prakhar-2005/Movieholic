package com.example.movieholic.domain.usecase

import com.example.movieholic.data.models.people.PopularPeople
import com.example.movieholic.domain.repository.PopularPeopleRepository

class UpdatePopularPeopleUsecase(private val popularPeopleRepository: PopularPeopleRepository) {
    suspend fun execute(): List<PopularPeople>? = popularPeopleRepository.updatePopularPeople()
}