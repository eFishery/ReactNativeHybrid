package com.example.reacttest.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.reacttest.BuildConfig
import com.example.reacttest.reactmodule.NoteReactPackage
import com.facebook.react.ReactInstanceManager
import com.facebook.react.ReactRootView
import com.facebook.react.common.LifecycleState
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
import com.facebook.react.shell.MainReactPackage

class AddNoteActivity : AppCompatActivity(), DefaultHardwareBackBtnHandler {

    private lateinit var mReactRootView: ReactRootView
    private lateinit var mReactInstanceManager: ReactInstanceManager

    companion object {
        fun callingIntent(context: Context): Intent {
            val intent = Intent(context, AddNoteActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mReactRootView = ReactRootView(this)
        mReactInstanceManager = ReactInstanceManager.builder()
            .setApplication(application)
            .setCurrentActivity(this)
            .setBundleAssetName("AddNoteComponent.android.bundle")
            .setJSMainModulePath("AddNoteComponent")
            .addPackage(NoteReactPackage(applicationContext))
            .addPackage(MainReactPackage())
            .setUseDeveloperSupport(BuildConfig.DEBUG)
            .setInitialLifecycleState(LifecycleState.RESUMED)
            .build()

        mReactRootView.startReactApplication(
            mReactInstanceManager,
            "AddNoteComponent",
            null
        )

        setContentView(mReactRootView)
    }


    override fun invokeDefaultOnBackPressed() {
        super.onBackPressed()
    }
}
