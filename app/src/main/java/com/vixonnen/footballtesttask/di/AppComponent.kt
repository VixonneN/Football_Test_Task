package com.vixonnen.footballtesttask.di

import android.content.Context
import com.vixonnen.footballtesttask.presentation.fixtures_screen.screen.FixturesFragment
import com.vixonnen.footballtesttask.presentation.league_screen.screen.LeagueFragment
import com.vixonnen.footballtesttask.presentation.splash_screen.screen.SplashFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NetworkModule::class,
    ViewModelModule::class,
    DataModule::class,
    DatabaseModule::class
])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(fragment: SplashFragment)
    fun inject(fragment: LeagueFragment)
    fun inject(fragment: FixturesFragment)
}