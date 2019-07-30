package com.example.reacttest

import android.app.Application
import com.example.reacttest.di.ApplicationComponent
import com.example.reacttest.di.ApplicationModule
import com.example.reacttest.di.DaggerApplicationComponent
import com.facebook.react.bridge.ReactApplicationContext

class App : Application() {

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this, ReactApplicationContext(this)))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }
}