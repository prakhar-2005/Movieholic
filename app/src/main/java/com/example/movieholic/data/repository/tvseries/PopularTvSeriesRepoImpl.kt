package com.example.movieholic.data.repository.tvseries

import android.util.Log
import com.example.movieholic.data.models.tvShows.PopularTvSeries
import com.example.movieholic.data.repository.tvseries.datasource.PopularTvSeriesCacheDatasource
import com.example.movieholic.data.repository.tvseries.datasource.PopularTvSeriesLocalDatasource
import com.example.movieholic.data.repository.tvseries.datasource.PopularTvSeriesRemoteDatasource
import com.example.movieholic.domain.repository.PopularTvSeriesRepository

class PopularTvSeriesRepoImpl(
    private val tvSeriesRemoteDatasource: PopularTvSeriesRemoteDatasource,
    private val tvSeriesLocalDatasource: PopularTvSeriesLocalDatasource,
    private val tvSeriesCacheDatasource: PopularTvSeriesCacheDatasource
): PopularTvSeriesRepository {
    override suspend fun getPopularTvSeries(): List<PopularTvSeries>? {
        return getTvSeriesFromCache()
    }

    override suspend fun updatePopularTvSeries(): List<PopularTvSeries>? {
        val newTvSeriesList = getTvSeriesFromApi()
        tvSeriesLocalDatasource.clearAll()
        tvSeriesLocalDatasource.savePopularTvSeriesToDB(newTvSeriesList)
        tvSeriesCacheDatasource.savePopularTvSeriesToCache(newTvSeriesList)

        return newTvSeriesList
    }

    suspend fun getTvSeriesFromApi():List<PopularTvSeries>{
        lateinit var tvSeriesList: List<PopularTvSeries>

        //exception handling
        try{
            val response = tvSeriesRemoteDatasource.getPopularTvSeries()
            val body = response.body()
            if(body!=null){
                tvSeriesList = body.popularTvSeries
            }
        }catch(exception: Exception){
            Log.i("MYTAG", exception.message.toString())
        }

        return tvSeriesList
    }

    suspend fun getTvSeriesFromDB(): List<PopularTvSeries>{
        lateinit var tvSeriesList: List<PopularTvSeries>

        try {
            tvSeriesList = tvSeriesLocalDatasource.getPopularTvSeriesFromDB()

        }catch(exception: Exception){
            Log.i("MYTAG", exception.message.toString())
        }

        if(tvSeriesList.isNotEmpty()){
            return tvSeriesList
        }else{
            tvSeriesList = getTvSeriesFromApi()
            tvSeriesLocalDatasource.savePopularTvSeriesToDB(tvSeriesList)
        }

        return tvSeriesList
    }

    suspend fun getTvSeriesFromCache(): List<PopularTvSeries>{
        lateinit var tvSeriesList: List<PopularTvSeries>

        try {
            tvSeriesList = tvSeriesCacheDatasource.getPopularTvSeriesFromCache()
        }catch(exception: Exception){
            Log.i("MYTAG", exception.message.toString())
        }

        if(tvSeriesList.isNotEmpty()){
            return tvSeriesList
        }else{
            tvSeriesList = getTvSeriesFromDB()
            tvSeriesCacheDatasource.savePopularTvSeriesToCache(tvSeriesList)
        }

        return tvSeriesList
    }
}