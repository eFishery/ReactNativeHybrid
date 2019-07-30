package com.example.reacttest.reactmodule

import android.content.Context
import android.util.Log
import com.example.reacttest.App
import com.example.reacttest.di.ApplicationComponent
import com.example.reacttest.domain.Note
import com.example.reacttest.domain.NoteRepository
import com.facebook.react.bridge.*
import com.google.gson.Gson
import org.json.JSONObject
import java.util.*
import javax.inject.Inject

class ReactDataModule(
    context: Context,
    reactContext: ReactApplicationContext
) : ReactContextBaseJavaModule(reactContext) {

    private val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (context as App).appComponent
    }

    @Inject
    lateinit var noteRepository: NoteRepository

    override fun getName(): String {
        return "DataModule"
    }

    @ReactMethod
    fun getListNote(promise: Promise) {
        appComponent.inject(this)
        try {
            val notes = noteRepository.findAll()

//            val notes = listOf(
//                Note(UUID.randomUUID().toString(), "1", "Satu-satu", Date().toString()),
//                Note(UUID.randomUUID().toString(), "2", "Dua-dua", Date().toString()),
//                Note(UUID.randomUUID().toString(), "3", "Tiga-tiga", Date().toString()),
//                Note(UUID.randomUUID().toString(), "4", "Empat-empat", Date().toString())
//            )

            val notesPromise = WritableNativeArray()
            notes.forEach {
                val notePromise = NativeModelConverter.convertJsonToMap(JSONObject(Gson().toJson(it)))
                notesPromise.pushMap(notePromise)
            }

            promise.resolve(notesPromise)
        } catch (e: Exception) {
            e.printStackTrace()
            promise.reject(e)
        }
    }

    @ReactMethod
    fun getDetailNote(uuid: String, promise: Promise) {
        appComponent.inject(this)
        try {
            val note = noteRepository.findById(uuid)
//            val note = Note(UUID.randomUUID().toString(), "1", "Satu-satu", Date().toString())
            val notePromise = NativeModelConverter.convertJsonToMap(JSONObject(Gson().toJson(note)))

            promise.resolve(notePromise)
        } catch (e: Exception) {
            e.printStackTrace()
            promise.reject(e)
        }
    }

    @ReactMethod
    fun saveNote(title: String, body: String) {
        appComponent.inject(this)
        try {
            val note = Note(
                UUID.randomUUID().toString(),
                title,
                body,
                Date().toString()
            )

//            Log.d("Data", "$note")

            noteRepository.store(note)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}