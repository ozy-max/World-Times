package com.test.times.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale
import java.util.TimeZone

private const val TIME_FORMAT_PATTERN = "HH:mm:ss"
private const val TIME_ZONE = "UTC"
private const val MILLI_SECONDS_RANGE = 1000L

object TimeConverter {
    @RequiresApi(Build.VERSION_CODES.O)
    fun parseStringToTimestamp(dateTimeString: String): Long {
        val dateTime = LocalDateTime.parse(dateTimeString)
        return dateTime.toEpochSecond(ZoneOffset.UTC) * MILLI_SECONDS_RANGE
    }

    fun formatTime(time: Long): String {
        val dateFormat = SimpleDateFormat(TIME_FORMAT_PATTERN, Locale.getDefault())
        dateFormat.timeZone = TimeZone.getTimeZone(TIME_ZONE)
        return dateFormat.format(Date(time))
    }
}
