package com.example.busschedule.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BussinDao {
    @Query("SELECT * FROM items ORDER BY arrivalTimeInMillis ASC")
    fun getAllBusSchedules(): Flow<List<BusSchedule>>

    @Query("SELECT * FROM items WHERE stopName = :stopName")
    fun getBusSchedule(stopName: String): Flow<List<BusSchedule>>
}