package com.example.movieholic.data.repository.people.datasourceimpl

import com.example.movieholic.data.db.PopularPeopleDao
import com.example.movieholic.data.models.people.PopularPeople
import com.example.movieholic.data.repository.people.datasource.PopularPeopleLocalDatasource

class PeopleLocalDatasourceImpl(private val peopleDao: PopularPeopleDao): PopularPeopleLocalDatasource {
    override suspend fun getPopularPeopleFromDB(): List<PopularPeople> {
        return peopleDao.getAllPopularPeople()
    }

    override suspend fun savePopularPeopleToDB(people: List<PopularPeople>) {
//        CoroutineScope(Dispatchers.IO).launch{
//            peopleDao.savePopularPeople(people)
//        }
    }

    override suspend fun clearAll() {
//        CoroutineScope(Dispatchers.IO).launch{
//            peopleDao.deleteAllPopularPeople()
//        }
    }
}