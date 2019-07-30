package com.example.reacttest.domain

interface NoteRepository {

    fun findAll(): List<Note>

    fun findById(uuid: String): Note

    fun store(note: Note)
}