package com.vixonnen.footballtesttask.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
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
    fun bindRegistrationViewModel(viewModel: SplashFragmentViewModel): ViewModel

}