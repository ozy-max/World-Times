package com.test.times.timer.ui.views

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.test.times.core.mvi.SIDE_EFFECTS_KEY
import com.test.times.timer.ui.TimerPageContract
import com.test.times.utils.theme.views.ViewLoading
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TimesPageScreen(
    state: TimerPageContract.State,
    effectFlow: Flow<TimerPageContract.Effect>?,
    onEventSent: (event: TimerPageContract.Event) -> Unit,
    onNavigationRequested: (TimerPageContract.Effect.Navigation) -> Unit
) {
    LaunchedEffect(SIDE_EFFECTS_KEY) {
        effectFlow?.onEach { effect ->
            when (effect) {
                is TimerPageContract.Effect.Navigation.ToCities -> {
                    onNavigationRequested(TimerPageContract.Effect.Navigation.ToCities)
                }
            }
        }?.collect()
    }
    when {
        state.isLoading -> ViewLoading()
        state.error != null -> TimesViewError(state) {
            onEventSent(TimerPageContract.Event.Retry)
        }

        else -> TimesViewDisplay(state = state) {
            onEventSent(TimerPageContract.Event.ButtonSelection)
        }
    }
}
