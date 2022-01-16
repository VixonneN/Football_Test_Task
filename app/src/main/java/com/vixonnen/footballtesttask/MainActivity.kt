package com.vixonnen.footballtesttask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.onesignal.OSNotificationOpenedResult
import com.onesignal.OneSignal
import com.vixonnen.footballtesttask.presentation.splash_screen.screen.SplashFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val controller =
            supportFragmentManager
                .findFragmentById(R.id.fragment_container_view)?.findNavController()

        OneSignal.setNotificationOpenedHandler { result ->
            val launchURL = result?.notification?.launchURL
            if (launchURL != null) {
                val bundle = Bundle()
                bundle.putString("url", launchURL)
                controller?.navigate(R.id.action_splashFragment_to_oneSignalFragment, bundle)
            }
        }
    }
}