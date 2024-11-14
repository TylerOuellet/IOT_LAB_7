package com.example.busschedule.ui

import android.app.Application
import com.example.busschedule.data.busDB

class BusScheduleApplication : Application() {
    val database: busDB by lazy { busDB.getDatabase(this) }
}