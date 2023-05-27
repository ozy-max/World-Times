package com.test.times.timer.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.test.times.timer.ui.TimerPageContract
import com.test.times.timer.ui.views.TimesPageScreen
import com.test.times.timer.ui.TimerPageViewModel
import com.test.times.navigation.Screens

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TimeScreenDestination(
    navController: NavController,
) {
    val viewModel = hiltViewModel<TimerPageViewModel>()
    TimesPageScreen(
        state = viewModel.viewState.value,
        effectFlow = viewModel.effect,
        onEventSent = { event -> viewModel.setEvent(event) },
        onNavigationRequested = { navigationEffect ->
            if (navigationEffect is TimerPageContract.Effect.Navigation.ToCities) {
                navController.navigate(Screens.CapitalsPage.route)
            }
        }
    )
}