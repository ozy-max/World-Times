package com.test.times.timer.repository

import android.content.SharedPreferences
import com.test.times.capitals.model.listCities
import javax.inject.Inject

private const val TIME_ZONE = "TIME_ZONE"

class TimerPageLocalRepositoryImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : TimerPageLocalRepository {

    override suspend fun putTimeZoneData(timeZone: String) {
        sharedPreferences.edit().putString(TIME_ZONE, timeZone).apply()
    }

    override suspend fun getTimeZoneData(): String {
        val defaultTimeZone = listCities.first().getTimeZone()
        return sharedPreferences.getString(TIME_ZONE, defaultTimeZone) ?: defaultTimeZone
    }
}