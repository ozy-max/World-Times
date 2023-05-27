package com.test.times.timer.repository

interface TimerPageLocalRepository {
    suspend fun putTimeZoneData(timeZone: String)
    suspend fun getTimeZoneData(): String
}