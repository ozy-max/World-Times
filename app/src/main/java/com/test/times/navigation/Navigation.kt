package com.test.times.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.test.times.capitals.navigation.CapitalsScreenDestination
import com.test.times.timer.navigation.TimeScreenDestination

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.TimesPage.route) {

        composable(route = Screens.TimesPage.route) {
            TimeScreenDestination(navController = navController)
        }

        composable(route = Screens.CapitalsPage.route) {
            CapitalsScreenDestination(navController = navController)
        }
    }
}
