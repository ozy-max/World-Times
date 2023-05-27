package com.test.times.utils.timer

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import javax.inject.Inject

@Parcelize
data class Time @Inject constructor(
    var hour: Int,
    var minute: Int,
    var second: Int,
    var milliSecond: Int,
    var day: Int,
    var month: Int,
    var year: Int
) : Parcelable
