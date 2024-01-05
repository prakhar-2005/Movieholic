package com.example.movieholic.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieholic.data.models.people.PopularPeople

@Dao
interface PopularPeopleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE) //to replace old data and continue transaction
    suspend fun savePopularPeople(people: List<PopularPeople>)

    @Query("DELETE FROM popular_people")
    suspend fun deleteAllPopularPeople()

    @Query("SELECT * FROM popular_people")
    suspend fun getAllPopularPeople(): List<PopularPeople>
}