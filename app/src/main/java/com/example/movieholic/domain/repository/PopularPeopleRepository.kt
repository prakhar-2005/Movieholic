package com.example.movieholic.domain.repository

import com.example.movieholic.data.models.people.PopularPeople

interface PopularPeopleRepository {
    suspend fun getPopularPeople(): List<PopularPeople>?
    suspend fun updatePopularPeople(): List<PopularPeople>?
}