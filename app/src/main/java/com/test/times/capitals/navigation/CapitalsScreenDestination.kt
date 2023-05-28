package com.test.times.capitals.navigation

import CapitalsPageScreen
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.test.times.capitals.ui.CapitalsContract
import com.test.times.capitals.ui.CapitalsViewModel
import com.test.times.navigation.Screens

@Composable
fun CapitalsScreenDestination(navController: NavController) {
    val viewModel = hiltViewModel<CapitalsViewModel>()
    CapitalsPageScreen(
        state = viewModel.viewState.value,
        effectFlow = viewModel.effect,
        onEventSent = { event -> viewModel.setEvent(event) },
        onNavigationRequested = { navigationEffect ->
            if (navigationEffect is CapitalsContract.Effect.Navigation.ToTimePage) {
                navController.navigate(Screens.TimerPage.route)
            } else if (navigationEffect is CapitalsContract.Effect.Navigation.Back) {
                navController.popBackStack()
            }
        }
    )
}
