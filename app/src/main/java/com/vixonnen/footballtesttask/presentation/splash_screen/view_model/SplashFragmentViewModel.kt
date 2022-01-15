package com.vixonnen.footballtesttask.presentation.splash_screen.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vixonnen.footballtesttask.domain.entity.fixtures.DataFixturesEntity
import com.vixonnen.footballtesttask.domain.entity.league.DataLeagueEntity
import com.vixonnen.footballtesttask.domain.use_cases.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashFragmentViewModel @Inject constructor(
    private val getLeaguesUseCase: GetLeaguesUseCase,
    private val getFixturesUseCase: GetFixturesUseCase,
    private val insertLeaguesUseCase: InsertLeaguesUseCase,
    private val insertFixturesUseCase: InsertFixturesUseCase
) : ViewModel() {

    private val _leagues = MutableLiveData<DataLeagueEntity>()
    val leagues: LiveData<DataLeagueEntity> = _leagues

    private val _fixtures = MutableLiveData<DataFixturesEntity>()
    val fixtures: LiveData<DataFixturesEntity> = _fixtures

    fun getLeagues() {
        viewModelScope.launch {
            val response = getLeaguesUseCase.invoke()
            _leagues.value = response
            response.result.forEach { leagueData ->
                insertLeaguesUseCase.invoke(leagueData)
            }
        }
    }

    fun getFixtures() {
        viewModelScope.launch {
            val response = getFixturesUseCase.invoke()
            _fixtures.value = response
            response.result.forEach { fixturesData ->
                insertFixturesUseCase.invoke(fixturesData)
            }
        }
    }
}