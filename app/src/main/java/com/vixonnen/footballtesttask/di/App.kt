package com.vixonnen.footballtesttask.di

import android.app.Application
import android.os.Bundle
import com.onesignal.OneSignal
import com.vixonnen.footballtesttask.R


class App : Application() {

    companion object {
        private const val ONESIGNAL_APP_ID = "97f362fe-535f-4b99-b223-bd27e4f27138"
    }

    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    private fun initializeComponent() : AppComponent =
        DaggerAppComponent.factory().create(applicationContext)

    override fun onCreate() {
        super.onCreate()
        // Enable verbose OneSignal logging to debug issues if needed.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        // OneSignal Initialization
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)

        OneSignal.setNotificationOpenedHandler { result ->
            val launchURL = result?.notification?.launchURL
            if (launchURL != null) {
                val bundle = Bundle()
                bundle.putString("url", launchURL)
            }
        }
    }
}