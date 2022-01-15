package com.vixonnen.footballtesttask.presentation.splash_screen.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vixonnen.footballtesttask.domain.use_cases.GetFixturesUseCase
import com.vixonnen.footballtesttask.domain.use_cases.GetLeaguesUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashFragmentViewModel @Inject constructor(
    private val getLeaguesUseCase: GetLeaguesUseCase,
    private val getFixturesUseCase: GetFixturesUseCase,
) : ViewModel() {

    fun getLeagues() {
        viewModelScope.launch {
            getLeaguesUseCase.invoke()
        }
    }

    fun getFixtures() {
        viewModelScope.launch {
            getFixturesUseCase.invoke("177")
        }
    }

}