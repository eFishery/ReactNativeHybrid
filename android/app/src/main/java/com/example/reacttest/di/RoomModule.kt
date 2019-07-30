package com.example.reacttest.di

import android.content.Context
import androidx.room.Room
import com.example.reacttest.infrastructure.AppDatabase
import com.example.reacttest.infrastructure.NoteDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java, "arch-db"
        ).build()

    @Provides
    @Singleton
    fun provideNoteDao(appDatabase: AppDatabase): NoteDao = appDatabase.noteDao()
}
