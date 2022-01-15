package com.vixonnen.footballtesttask.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vixonnen.footballtesttask.presentation.fixtures_screen.view_model.FixturesFragmentViewModel
import com.vixonnen.footballtesttask.presentation.league_screen.view_model.LeagueFragmentViewModel
import com.vixonnen.footballtesttask.presentation.splash_screen.view_model.SplashFragmentViewModel
import com.vixonnen.footballtesttask.presentation.view_model_factory.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(
        factory: ViewModelFactory
    ) : ViewModelProvider.Factory

    @Binds
    @IntoMap
    @Singleton
    @ViewModelKey(SplashFragmentViewModel::class)
    fun bindSplashViewModel(viewModel: SplashFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @Singleton
    @ViewModelKey(FixturesFragmentViewModel::class)
    fun bindFixturesViewModel(viewModel: FixturesFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @Singleton
    @ViewModelKey(LeagueFragmentViewModel::class)
    fun bindLeagueViewModel(viewModel: LeagueFragmentViewModel): ViewModel

}