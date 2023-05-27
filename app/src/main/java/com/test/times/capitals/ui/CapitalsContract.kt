package com.test.times.capitals.ui

import com.test.times.capitals.model.City
import com.test.times.core.mvi.ViewEvent
import com.test.times.core.mvi.ViewSideEffect
import com.test.times.core.mvi.ViewState


class CapitalsContract {

    sealed class Event : ViewEvent {
        data class SaveTimeZoneAndNavigate(val timeZone: String) : Event()
        object BackButtonClicked : Event()
    }

    data class State(
        val cities: List<City>? = null,
        val isLoading: Boolean = false,
        val error: String? = null
    ) : ViewState

    sealed class Effect : ViewSideEffect {
        sealed class Navigation : Effect() {
            object Back : Navigation()
            object ToTimePage : Navigation()
        }
    }

}
