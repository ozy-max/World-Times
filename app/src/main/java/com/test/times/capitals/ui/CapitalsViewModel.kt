package com.test.times.capitals.ui

import com.test.times.capitals.model.listCities
import com.test.times.core.mvi.BaseViewModel
import com.test.times.timer.interactor.TimerPageInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CapitalsViewModel @Inject constructor(
    private val timesPageInteractor: TimerPageInteractor
) : BaseViewModel<CapitalsContract.Event, CapitalsContract.State, CapitalsContract.Effect>() {

    init {
        saveTimeZone()
    }

    override fun setInitialState() = CapitalsContract.State(
        isLoading = true,
        error = null
    )

    override fun handleEvents(event: CapitalsContract.Event) {
        when (event) {
            is CapitalsContract.Event.BackButtonClicked -> setEffect { CapitalsContract.Effect.Navigation.Back }
            is CapitalsContract.Event.SaveTimeZoneAndNavigate -> {
                saveTimeZone(event.timeZone)
                setEffect { CapitalsContract.Effect.Navigation.ToTimePage }
            }
        }
    }

    private fun saveTimeZone(timeZone: String? = null) {
        launch {
            setState { copy(isLoading = true, error = null) }
            try {
                setState { copy(cities = listCities, isLoading = false, error = null) }
                timeZone?.let { timesPageInteractor.saveTimeZone(it) }
                setState { copy(isLoading = false, error = null) }
            } catch (e: CancellationException) {
                Timber.e(e)
                setState { copy(isLoading = false, error = e.message) }
            } catch (t: Throwable) {
                Timber.e(t)
                setState { copy(isLoading = false, error = t.message) }
            }
        }
    }

}