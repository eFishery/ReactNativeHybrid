package com.example.reacttest.reactmodule

import android.content.Context
import android.util.Log
import com.example.reacttest.App
import com.example.reacttest.di.ApplicationComponent
import com.example.reacttest.view.Navigator
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import javax.inject.Inject

class ReactNavigatorModule(
    private val context: Context,
    reactContext: ReactApplicationContext
) : ReactContextBaseJavaModule(reactContext) {

    private val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (context as App).appComponent
    }

    @Inject
    lateinit var navigator: Navigator

    override fun getName(): String {
        return "NavigatorModule"
    }

    @ReactMethod
    fun showListNotesActivity() {
        appComponent.inject(this)
        navigator.showNotes(context)
    }

    @ReactMethod
    fun showDetailNoteActivity(uuid: String) {
        appComponent.inject(this)
        navigator.showNoteDetail(context, uuid)
    }

    @ReactMethod
    fun showAddNoteActivity() {
        appComponent.inject(this)
        navigator.showAddNote(context)
    }
}
