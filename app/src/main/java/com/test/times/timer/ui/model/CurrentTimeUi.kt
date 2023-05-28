package com.test.times.timer.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrentTimeUi(
    val dateTime: Long,
    val date: String,
    val timeZone: String?
) : Parcelable
