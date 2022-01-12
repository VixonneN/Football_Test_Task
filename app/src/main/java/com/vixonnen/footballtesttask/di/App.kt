package com.vixonnen.footballtesttask.di

import android.app.Application


class App : Application() {

    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    private fun initializeComponent() : AppComponent =
        DaggerAppComponent.factory().create(applicationContext)
}