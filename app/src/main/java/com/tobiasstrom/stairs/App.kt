package com.tobiasstrom.stairs

import android.app.Application
import android.util.Log
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.tobiasstrom.stairs.common.commonModule
import com.tobiasstrom.stairs.examplea.aModule
import com.tobiasstrom.stairs.track.bModule
import com.tobiasstrom.stairs.examplec.cModule
import com.tobiasstrom.stairs.main.mainModule
import com.tobiasstrom.stairs.startup.onboardingModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(mainModule, commonModule, onboardingModule, aModule, bModule, cModule))
        }
        initLogging()
    }

    private fun initLogging() {
        val min = if (BuildConfig.DEBUG) Log.VERBOSE else Log.DEBUG
        Timber.plant(if (BuildConfig.DEBUG) Timber.DebugTree() else CrashReportingTree(min))
    }

    private class CrashReportingTree(private val minPriority: Int) : Timber.Tree() {
        override fun isLoggable(tag: String?, priority: Int): Boolean = priority > minPriority
        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
            super.log(priority, tag, message, t)
            val inst = FirebaseCrashlytics.getInstance()
            if (t != null) {
                inst.recordException(t)
            } else {
                inst.log("$message [priority=$priority, tag=$tag]")
            }
        }
    }
}
