package com.example.reacttest.di

import com.example.reacttest.App
import com.example.reacttest.reactmodule.ReactDataModule
import com.example.reacttest.reactmodule.ReactNavigatorModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        DataModule::class,
        RoomModule::class
    ]
)
interface ApplicationComponent {

    fun inject(application: App)

    fun inject(reactDataModule: ReactDataModule)

    fun inject(reactNavigatorModule: ReactNavigatorModule)
}