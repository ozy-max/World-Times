package com.test.times.timer.repository

import com.test.times.core.mvi.Resource
import com.test.times.timer.model.CurrentTime

interface TimerPageRemoteRepository {
    suspend fun getCurrentTimeByTimeZone(timezone: String): Resource<CurrentTime>
}