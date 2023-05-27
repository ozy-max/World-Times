package com.test.times.navigation

sealed class Screens(val route: String){
    object TimerPage: Screens("times_page")
    object CapitalsPage: Screens("capitals_page")
}
