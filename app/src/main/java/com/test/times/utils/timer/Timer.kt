package com.test.times.utils.timer

import com.test.times.core.di.MainDispatcher
import com.test.times.utils.TimeConverter.formatTime
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val MILLI_SECONDS_RANGE = 1000L


class Timer @Inject constructor(
    @MainDispatcher private val dispatcherMain: CoroutineDispatcher
) : TimerAction {
    private var isRunning: Boolean = false
    private var job: Job? = null

    private val _currentTimeFlow: MutableSharedFlow<String> = MutableSharedFlow()
    val currentTimeFlow = _currentTimeFlow.asSharedFlow()

    override fun start(startTime: Long) {
        if (!isRunning) {
            isRunning = true
            job = CoroutineScope(dispatcherMain).launch {
                var currentTime = startTime
                while (isActive) {
                    val formattedTime = formatTime(currentTime)
                    _currentTimeFlow.emit(formattedTime)
                    currentTime += MILLI_SECONDS_RANGE
                    delay(MILLI_SECONDS_RANGE)
                }
            }
        }
    }

    override fun stop() {
        if (isRunning) {
            isRunning = false
            job?.cancel()
        }
    }
}
