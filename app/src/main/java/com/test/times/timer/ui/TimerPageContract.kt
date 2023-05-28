package com.test.times.timer.ui

import com.test.times.core.mvi.ViewEvent
import com.test.times.core.mvi.ViewSideEffect
import com.test.times.core.mvi.ViewState

class TimerPageContract {

    sealed class Event : ViewEvent {
        object Retry : Event()
        object ButtonSelection : Event()
    }
    data class State(
        val dateTime: String? = null,
        val timeZone: String? = null,
        val date: String? = null,
        val isLoading: Boolean = false,
        val error: String? = null
    ) : ViewState

    sealed class Effect : ViewSideEffect {
        sealed class Navigation : Effect() {
            object ToCities : Navigation()
        }
    }
}
