package com.vixonnen.footballtesttask.presentation.splash_screen.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vixonnen.footballtesttask.domain.use_cases.GetAllLeaguesUseCase
import com.vixonnen.footballtesttask.domain.use_cases.GetMatchesUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashFragmentViewModel @Inject constructor(
    private val getAllLeaguesUseCase: GetAllLeaguesUseCase,
    private val getMatchesUseCase: GetMatchesUseCase,
) : ViewModel() {

    fun getAllLeagues() {
        viewModelScope.launch {
            getAllLeaguesUseCase.invoke()
        }
    }

    fun getMatches() {
        viewModelScope.launch {
            getMatchesUseCase.invoke()
        }
    }
}