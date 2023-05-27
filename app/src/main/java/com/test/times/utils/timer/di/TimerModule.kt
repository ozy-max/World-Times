package com.test.times.utils.timer.di

import com.test.times.utils.timer.Timer
import com.test.times.utils.timer.TimerAction
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class TimerModule {

    @Binds
    abstract fun bindTimerAction(timer: Timer): TimerAction

}
