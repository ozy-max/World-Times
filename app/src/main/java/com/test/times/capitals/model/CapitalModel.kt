package com.test.times.capitals.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable

@Immutable
data class City(
    val capitalName: String,
    val continentName: String,
    @DrawableRes val imageFlag: Int
) {
    fun getTimeZone() = "$continentName/$capitalName"
}
