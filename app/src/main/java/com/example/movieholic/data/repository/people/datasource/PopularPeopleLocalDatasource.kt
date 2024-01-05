package com.example.movieholic.data.repository.people.datasource

import com.example.movieholic.data.models.people.PopularPeople

interface PopularPeopleLocalDatasource {
    suspend fun getPopularPeopleFromDB(): List<PopularPeople>
    suspend fun savePopularPeopleToDB(people: List<PopularPeople>)
    suspend fun clearAll()
}