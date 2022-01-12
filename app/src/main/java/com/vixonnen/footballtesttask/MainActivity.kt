package com.vixonnen.footballtesttask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vixonnen.footballtesttask.presentation.splash_screen.screen.SplashFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_view, SplashFragment.newInstance())
            .commit()
    }
}