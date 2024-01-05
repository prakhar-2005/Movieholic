package com.example.movieholic.data.repository.people.datasource

import com.example.movieholic.data.models.people.PopularPeopleList
import retrofit2.Response

interface PopularPeopleRemoteDatasource {
    suspend fun getPopularPeople(): Response<PopularPeopleList>
}