package com.example.reacttest.di

import com.example.reacttest.domain.NoteRepository
import com.example.reacttest.infrastructure.NoteRepositoryImp
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideNoteRepository(noteRepositoryImp: NoteRepositoryImp): NoteRepository = noteRepositoryImp
}