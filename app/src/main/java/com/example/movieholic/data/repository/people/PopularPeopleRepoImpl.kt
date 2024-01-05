package com.example.movieholic.data.repository.people

import android.util.Log
import com.example.movieholic.data.models.people.PopularPeople
import com.example.movieholic.data.repository.people.datasource.PopularPeopleCacheDatasource
import com.example.movieholic.data.repository.people.datasource.PopularPeopleLocalDatasource
import com.example.movieholic.data.repository.people.datasource.PopularPeopleRemoteDatasource
import com.example.movieholic.domain.repository.PopularPeopleRepository

class PopularPeopleRepoImpl(
    private val peopleRemoteDatasource: PopularPeopleRemoteDatasource,
    private val peopleLocalDatasource: PopularPeopleLocalDatasource,
    private val peopleCacheDatasource: PopularPeopleCacheDatasource
): PopularPeopleRepository {
    override suspend fun getPopularPeople(): List<PopularPeople>? {
        return getPeopleFromCache()
    }

    override suspend fun updatePopularPeople(): List<PopularPeople>? {
        val newPeopleList = getPeopleFromApi()
        peopleLocalDatasource.clearAll()
        peopleLocalDatasource.savePopularPeopleToDB(newPeopleList)
        peopleCacheDatasource.savePopularPeopleToCache(newPeopleList)

        return newPeopleList
    }

    suspend fun getPeopleFromApi():List<PopularPeople>{
        lateinit var peopleList: List<PopularPeople>

        //exception handling
        try{
            val response = peopleRemoteDatasource.getPopularPeople()
            val body = response.body()
            if(body!=null){
                peopleList = body.popularPeople
            }
        }catch(exception: Exception){
            Log.i("MYTAG", exception.message.toString())
        }

        return peopleList
    }

    suspend fun getPeopleFromDB(): List<PopularPeople>{
        lateinit var peopleList: List<PopularPeople>

        try {
            peopleList = peopleLocalDatasource.getPopularPeopleFromDB()

        }catch(exception: Exception){
            Log.i("MYTAG", exception.message.toString())
        }

        if(peopleList.size>0){
            return peopleList
        }else{
            peopleList=getPeopleFromApi()
            peopleLocalDatasource.savePopularPeopleToDB(peopleList)
        }

        return peopleList
    }

    suspend fun getPeopleFromCache(): List<PopularPeople>{
        lateinit var peopleList: List<PopularPeople>

        try {
            peopleList = peopleCacheDatasource.getPopularPeopleFromCache()
        }catch(exception: Exception){
            Log.i("MYTAG", exception.message.toString())
        }

        if(peopleList.size>0){
            return peopleList
        }else{
            peopleList = getPeopleFromDB()
            peopleCacheDatasource.savePopularPeopleToCache(peopleList)
        }

        return peopleList
    }
}