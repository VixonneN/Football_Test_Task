package com.vixonnen.footballtesttask.presentation.splash_screen.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vixonnen.footballtesttask.domain.use_cases.GetAllLeaguesUseCase
import com.vixonnen.footballtesttask.domain.use_cases.GetCountryUseCase
import com.vixonnen.footballtesttask.domain.use_cases.GetMatchesUseCase
import com.vixonnen.footballtesttask.domain.use_cases.GetSeasonUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashFragmentViewModel @Inject constructor(
    private val getAllLeaguesUseCase: GetAllLeaguesUseCase,
    private val getMatchesUseCase: GetMatchesUseCase,
    private val getSeasonUseCase: GetSeasonUseCase,
    private val getCountryUseCase: GetCountryUseCase
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

    fun getSeason() {
        viewModelScope.launch {
            getSeasonUseCase.invoke()
        }
    }

    fun getCountry() {
        viewModelScope.launch {
            getCountryUseCase.invoke()
        }
    }
}