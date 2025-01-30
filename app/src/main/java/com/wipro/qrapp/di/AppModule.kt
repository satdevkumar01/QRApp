package com.wipro.qrapp.di

import android.app.Application
import android.content.Context
import com.wipro.qrapp.data.MacRepositoryImpl
import com.wipro.qrapp.domain.repository.MacRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

// AppModule.kt
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideContext(application: Application): Context = application.applicationContext

    @Provides
    fun provideMacRepository(context: Context): MacRepository = MacRepositoryImpl(context)
}