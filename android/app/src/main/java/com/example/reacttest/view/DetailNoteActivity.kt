package com.example.reacttest.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.reacttest.BuildConfig
import com.example.reacttest.reactmodule.NoteReactPackage
import com.facebook.react.ReactInstanceManager
import com.facebook.react.ReactRootView
import com.facebook.react.common.LifecycleState
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
import com.facebook.react.shell.MainReactPackage

class DetailNoteActivity : AppCompatActivity(), DefaultHardwareBackBtnHandler {

    private lateinit var mReactRootView: ReactRootView
    private lateinit var mReactInstanceManager: ReactInstanceManager

    companion object {
        private const val KEY_NOTE_UUID = "KEY_NOTE_UUID"
        fun callingIntent(context: Context, uuid: String): Intent {
            val intent = Intent(context, DetailNoteActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK
            intent.putExtra(KEY_NOTE_UUID, uuid)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val noteUuid = intent.getStringExtra(KEY_NOTE_UUID)
//        Log.d("DetailNoteActivity", noteUuid)
        val initialProps = Bundle()
        initialProps.putString("uuid", noteUuid)

        mReactRootView = ReactRootView(this)
        mReactInstanceManager = ReactInstanceManager.builder()
            .setApplication(application)
            .setCurrentActivity(this)
            .setBundleAssetName("DetailNoteComponent.android.bundle")
            .setJSMainModulePath("DetailNoteComponent")
            .addPackage(NoteReactPackage(applicationContext))
            .addPackage(MainReactPackage())
            .setUseDeveloperSupport(BuildConfig.DEBUG)
            .setInitialLifecycleState(LifecycleState.RESUMED)
            .build()

        mReactRootView.startReactApplication(
            mReactInstanceManager,
            "DetailNoteComponent",
            initialProps
        )

        setContentView(mReactRootView)
    }

    override fun invokeDefaultOnBackPressed() {
        super.onBackPressed()
    }
}