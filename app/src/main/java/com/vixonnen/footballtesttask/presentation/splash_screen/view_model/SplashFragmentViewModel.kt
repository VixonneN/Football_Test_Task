package com.vixonnen.footballtesttask.presentation.splash_screen.view_model

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vixonnen.footballtesttask.domain.use_cases.GetFixturesUseCase
import com.vixonnen.footballtesttask.domain.use_cases.GetLeaguesFromDatabase
import com.vixonnen.footballtesttask.domain.use_cases.GetLeaguesUseCase
import com.vixonnen.footballtesttask.domain.use_cases.InsertLeaguesUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashFragmentViewModel @Inject constructor(
    private val getLeaguesUseCase: GetLeaguesUseCase,
    private val getFixturesUseCase: GetFixturesUseCase,
    private val insertLeaguesUseCase: InsertLeaguesUseCase,
    private val getLeaguesFromDatabase: GetLeaguesFromDatabase
) : ViewModel() {

    fun getLeagues() {
        viewModelScope.launch {
            getLeaguesUseCase.invoke()
        }
    }

    fun getFixtures() {
        viewModelScope.launch {
            getLeaguesUseCase.invoke().result.forEach {
                insertLeaguesUseCase.invoke(it)
                Log.d(TAG, "getFixtures: added $it")
            }
            delay(5000)
            Log.d(TAG, "getFixtures: ${getLeaguesFromDatabase.invoke()}")
        }

    }

}