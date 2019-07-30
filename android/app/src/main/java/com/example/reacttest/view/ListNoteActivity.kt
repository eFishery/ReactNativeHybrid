package com.example.reacttest.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import com.example.reacttest.BuildConfig
import com.example.reacttest.reactmodule.NoteReactPackage
import com.facebook.react.ReactInstanceManager
import com.facebook.react.ReactRootView
import com.facebook.react.common.LifecycleState
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
import com.facebook.react.shell.MainReactPackage


class ListNoteActivity : AppCompatActivity(), DefaultHardwareBackBtnHandler {

    private lateinit var mReactRootView: ReactRootView
    private lateinit var mReactInstanceManager: ReactInstanceManager

    companion object {
        fun callingIntent(context: Context): Intent {
            val intent = Intent(context, ListNoteActivity::class.java)
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
            .setBundleAssetName("ListNoteComponent.android.bundle")
            .setJSMainModulePath("ListNoteComponent")
            .addPackage(NoteReactPackage(applicationContext))
            .addPackage(MainReactPackage())
            .setUseDeveloperSupport(BuildConfig.DEBUG)
            .setInitialLifecycleState(LifecycleState.RESUMED)
            .build()

        mReactRootView.startReactApplication(
            mReactInstanceManager,
            "ListNoteComponent",
            null
        )

        setContentView(mReactRootView)
    }

    override fun invokeDefaultOnBackPressed() {
        super.onBackPressed()
    }

    override fun onResume() {
        super.onResume()
        mReactInstanceManager.onHostResume(this, this)
    }

    override fun onPause() {
        super.onPause()
        mReactInstanceManager.onHostPause(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mReactInstanceManager.onHostDestroy(this)
        mReactRootView.unmountReactApplication()
    }

    override fun onBackPressed() {
        mReactInstanceManager.onBackPressed()
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            mReactInstanceManager.showDevOptionsDialog()
            return true
        }
        return super.onKeyUp(keyCode, event)
    }
}