package com.example.busschedule.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BusSchedule::class], version = 1, exportSchema = false)
abstract class busDB : RoomDatabase() {

    abstract fun bussinDao(): BussinDao

    companion object {
        @Volatile
        private var Instance: busDB? = null

        fun getDatabase(context: Context): busDB {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, busDB::class.java, "item_database")
                    .build().also { Instance = it }
            }
        }
    }
}