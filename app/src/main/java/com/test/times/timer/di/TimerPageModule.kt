package com.test.times.timer.di

import com.test.times.timer.api.TimerPageApi
import com.test.times.timer.repository.TimerPageLocalRepository
import com.test.times.timer.repository.TimerPageLocalRepositoryImpl
import com.test.times.timer.repository.TimerPageRemoteRepositoryImpl
import com.test.times.timer.repository.TimerPageRemoteRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class TimerPageModule {

    @Binds
    abstract fun bindTimerRemoteRepository(
        timerRemoteRepository: TimerPageRemoteRepositoryImpl
    ): TimerPageRemoteRepository

    @Binds
    abstract fun bindTimerPageLocalRepository(
        timerPageLocalRepository: TimerPageLocalRepositoryImpl
    ): TimerPageLocalRepository

    companion object {
        @Provides
        @Singleton
        fun provideTimeApiService(retrofit: Retrofit): TimerPageApi {
            return retrofit.create(TimerPageApi::class.java)
        }
    }
}