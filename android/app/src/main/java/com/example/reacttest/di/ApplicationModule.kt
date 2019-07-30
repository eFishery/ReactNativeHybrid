package com.example.reacttest.di

import android.content.Context
import com.example.reacttest.App
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: App, private val reactApplicationContext: ReactApplicationContext) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application

    @Provides
    @Singleton
    fun provideReactApplicationContext(): ReactContext = reactApplicationContext
}