package com.test.times.timer.interactor

import android.os.Build
import androidx.annotation.RequiresApi
import com.test.times.core.mvi.Resource
import com.test.times.timer.repository.TimerPageLocalRepository
import com.test.times.timer.repository.TimerPageRemoteRepository
import com.test.times.timer.ui.model.CurrentTimeUi
import com.test.times.timer.ui.model.converter.TimerPageUiConverter
import javax.inject.Inject

class TimerPageInteractor @Inject constructor(
    private val timesPageRemoteRepository: TimerPageRemoteRepository,
    private val timesPageLocalRepository: TimerPageLocalRepository,
    private val timesPageUiConverter: TimerPageUiConverter
) {
    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun getCurrentTimeByTimeZone(): Resource<CurrentTimeUi> {
        val timezone = timesPageLocalRepository.getTimeZoneData()
        val currentTime = timesPageRemoteRepository.getCurrentTimeByTimeZone(timezone)

        return timesPageUiConverter.convert(
            currentTime.data ?: return Resource.Error("Error of getting time")
        )
    }

    suspend fun saveTimeZone(timezone: String) {
        timesPageLocalRepository.putTimeZoneData(timezone)
    }
}