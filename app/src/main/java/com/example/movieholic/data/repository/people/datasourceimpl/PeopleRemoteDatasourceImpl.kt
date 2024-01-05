package com.example.movieholic.data.repository.people.datasourceimpl

import com.example.movieholic.data.api.TMDBService
import com.example.movieholic.data.models.people.PopularPeopleList
import com.example.movieholic.data.repository.people.datasource.PopularPeopleRemoteDatasource
import retrofit2.Response

class PeopleRemoteDatasourceImpl(private val tmdbService: TMDBService, private val apiKey: String): PopularPeopleRemoteDatasource {
    override suspend fun getPopularPeople(): Response<PopularPeopleList> = tmdbService.getPopularPeople(apiKey)

}