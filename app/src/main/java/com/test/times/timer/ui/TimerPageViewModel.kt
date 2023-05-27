package com.test.times.timer.ui

import android.os.Build
import androidx.annotation.RequiresApi
import com.test.times.core.di.IoDispatcher
import com.test.times.core.mvi.BaseViewModel
import com.test.times.core.mvi.Resource
import com.test.times.timer.interactor.TimerPageInteractor
import com.test.times.utils.timer.Timer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class TimerPageViewModel @Inject constructor(
    private val timesPageInteractor: TimerPageInteractor,
    private val timer: Timer,
    @IoDispatcher private val dispatcherIo: CoroutineDispatcher
) : BaseViewModel<TimerPageContract.Event, TimerPageContract.State, TimerPageContract.Effect>() {

    init {
        loadCurrentTime()
    }

    override fun setInitialState() = TimerPageContract.State(
        dateTime = null,
        timeZone = null,
        isLoading = true,
        error = null
    )

    override fun handleEvents(event: TimerPageContract.Event) {
        when (event) {
            is TimerPageContract.Event.ButtonSelection -> setEffect { TimerPageContract.Effect.Navigation.ToCities }
            is TimerPageContract.Event.Retry -> loadCurrentTime()
        }
    }

    private fun loadCurrentTime() {
        launch {
            try {
                setState { copy(isLoading = true, error = null) }
                when (val result = withContext(dispatcherIo) { timesPageInteractor.getCurrentTimeByTimeZone() }) {
                    is Resource.Success -> {
                        setState {
                            copy(
                                dateTime = result.data?.dateTime.toString(),
                                timeZone = result.data?.timeZone,
                                isLoading = false
                            )
                        }
                        val currentTime = timesPageInteractor.getCurrentTimeByTimeZone()
                        currentTime.data?.timeZone?.let { timesPageInteractor.saveTimeZone(it) }
                        currentTime.data?.dateTime?.let { timer.start(it) }
                        currentTime.data?.timeZone?.let { updateTimer(it) }
                    }

                    is Resource.Error -> {
                        setState { copy(dateTime = null, timeZone = null, isLoading = false, error = result.message) }
                    }
                }
            } catch (e: CancellationException) {
                Timber.e(e)
                setState { copy(error = e.message, isLoading = false) }
            } catch (t: Throwable) {
                Timber.e(t)
                setState { copy(error = t.message, isLoading = false) }
            }
        }
    }

    private fun updateTimer(timeZone: String) {
        launch {
            try {
                timer.currentTimeFlow.collect { dateTime ->
                    setState { copy(dateTime = dateTime, timeZone = timeZone, isLoading = false, error = null) }
                }
            } catch (t: Throwable) {
                Timber.e(t)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        timer.stop()
    }

}
