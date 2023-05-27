package com.test.times.timer.api

import com.test.times.timer.api.model.CurrentTimeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TimerPageApi {

    @GET("Time/current/zone")
    suspend fun getCurrentTimeByTimeZone(
        @Query("timezone") timezone: String
    ): CurrentTimeResponse
}