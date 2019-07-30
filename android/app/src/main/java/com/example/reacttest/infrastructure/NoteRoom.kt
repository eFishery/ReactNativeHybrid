package com.example.reacttest.infrastructure

import androidx.room.*

@Entity(tableName = "note")
data class NoteEntity(
    @PrimaryKey val uuid: String,
    @ColumnInfo val title: String,
    @ColumnInfo val body: String,
    @ColumnInfo(name = "created_at") val createdAt: String
)

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    fun getAll(): List<NoteEntity>

    @Query("SELECT * FROM note WHERE uuid LIKE :uuid")
    fun getById(uuid: String): NoteEntity

    @Insert
    fun insertAll(vararg note: NoteEntity)

    @Delete
    fun delete(note: NoteEntity)
}