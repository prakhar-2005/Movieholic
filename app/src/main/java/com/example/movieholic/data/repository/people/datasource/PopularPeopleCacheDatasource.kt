package com.example.movieholic.data.repository.people.datasource

import com.example.movieholic.data.models.people.PopularPeople

interface PopularPeopleCacheDatasource {
    suspend fun getPopularPeopleFromCache(): List<PopularPeople>
    suspend fun savePopularPeopleToCache(people: List<PopularPeople>)
}