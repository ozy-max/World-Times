package com.test.times.timer.repository

import com.test.times.core.mvi.Resource
import com.test.times.timer.api.TimerPageApi
import com.test.times.timer.model.CurrentTime
import com.test.times.timer.model.converter.TimerPageConverter
import timber.log.Timber
import javax.inject.Inject

class TimerPageRemoteRepositoryImpl @Inject constructor(
    private val api: TimerPageApi,
    private val timesPageConverter: TimerPageConverter
) : TimerPageRemoteRepository {

    override suspend fun getCurrentTimeByTimeZone(timezone: String): Resource<CurrentTime> {
        return try {
            val currentTime = api.getCurrentTimeByTimeZone(timezone)
            timesPageConverter.convert(currentTime)
        } catch (t: Throwable) {
            Timber.e(t)
            Resource.Error(t.message ?: "Error of getting time")
        }
    }
}
