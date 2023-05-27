package com.test.times.timer.model.converter

import com.test.times.core.converter.BaseDataConverter
import com.test.times.core.mvi.Resource
import com.test.times.timer.api.model.CurrentTimeResponse
import com.test.times.timer.model.CurrentTime
import javax.inject.Inject

class TimerPageConverter @Inject constructor(
) : BaseDataConverter<CurrentTimeResponse, CurrentTime> {

    override fun convert(data: CurrentTimeResponse): Resource<CurrentTime> {
        return Resource.Success(
            CurrentTime(
                year = data.year,
                month = data.month,
                day = data.day,
                hour = data.hour,
                minute = data.minute,
                seconds = data.seconds,
                milliSeconds = data.milliSeconds,
                dateTime = data.dateTime,
                date = data.date,
                time = data.time,
                timeZone = data.timeZone,
                dayOfWeek = data.dayOfWeek ?: "",
                dstActive = data.dstActive
            )
        )
    }
}