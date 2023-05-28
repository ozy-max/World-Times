package com.test.times.timer.ui.model.converter

import android.os.Build
import androidx.annotation.RequiresApi
import com.test.times.core.converter.BaseDataConverter
import com.test.times.core.mvi.Resource
import com.test.times.timer.model.CurrentTime
import com.test.times.timer.ui.model.CurrentTimeUi
import com.test.times.utils.TimeConverter
import javax.inject.Inject

class TimerPageUiConverter @Inject constructor(
) : BaseDataConverter<CurrentTime, CurrentTimeUi> {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun convert(data: CurrentTime): Resource<CurrentTimeUi> {
       return Resource.Success(CurrentTimeUi(
           dateTime = TimeConverter.parseStringToTimestamp(data.dateTime),
           date = data.date.toString(),
           timeZone = data.timeZone
       ))
    }

}