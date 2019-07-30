package com.example.reacttest.infrastructure

import com.example.reacttest.domain.Note
import com.example.reacttest.domain.NoteRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoteRepositoryImp
@Inject constructor(private val noteDao: NoteDao) : NoteRepository {

    override fun findAll(): List<Note> {
        return noteDao.getAll()
            .map { NoteMapper.toDomain(it) }
    }

    override fun findById(uuid: String): Note {
        return NoteMapper.toDomain(noteDao.getById(uuid))
    }

    override fun store(note: Note) {
        noteDao.insertAll(NoteMapper.toEntity(note))
    }
}

object NoteMapper {

    fun toDomain(noteEntity: NoteEntity): Note {
        return Note(noteEntity.uuid, noteEntity.title, noteEntity.body, noteEntity.createdAt)
    }

    fun toEntity(note: Note): NoteEntity {
        return NoteEntity(note.uuid, note.title, note.body, note.createdAt)
    }
}