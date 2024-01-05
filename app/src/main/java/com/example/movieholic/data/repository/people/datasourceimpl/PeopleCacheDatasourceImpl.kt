package com.example.movieholic.data.repository.people.datasourceimpl

import com.example.movieholic.data.models.people.PopularPeople
import com.example.movieholic.data.repository.people.datasource.PopularPeopleCacheDatasource

class PeopleCacheDatasourceImpl: PopularPeopleCacheDatasource {
    private var peopleList = ArrayList<PopularPeople>()
    override suspend fun getPopularPeopleFromCache(): List<PopularPeople> {
        return peopleList
    }

    override suspend fun savePopularPeopleToCache(people: List<PopularPeople>) {
        peopleList.clear()
        peopleList = ArrayList(people)
    }
}