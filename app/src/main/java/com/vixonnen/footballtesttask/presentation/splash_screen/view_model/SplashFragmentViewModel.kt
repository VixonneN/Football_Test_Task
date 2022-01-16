package com.vixonnen.footballtesttask.presentation.splash_screen.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vixonnen.footballtesttask.domain.use_cases.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashFragmentViewModel @Inject constructor(
    private val getLeaguesUseCase: GetLeaguesUseCase,
    private val getFixturesUseCase: GetFixturesUseCase,
    private val insertLeaguesUseCase: InsertLeaguesUseCase,
    private val insertFixturesUseCase: InsertFixturesUseCase,
    private val checkFixturesDatabaseForData: CheckFixturesDatabaseForDataUseCase,
    private val checkLeagueDatabaseUseCase: CheckLeagueDatabaseForDataUseCase
) : ViewModel() {

    private val _leagues = MutableLiveData<String>()
    val leagues: LiveData<String> = _leagues

    private val _fixtures = MutableLiveData<String>()
    val fixtures: LiveData<String> = _fixtures

    fun getLeagues() {
        viewModelScope.launch {
            if (checkLeagueDatabaseUseCase.invoke() == 0) {
                val response = getLeaguesUseCase.invoke()

                response.result.forEach { leagueData ->
                    insertLeaguesUseCase.invoke(leagueData)
                }
                _leagues.value = "Лиги загружены"
            }
        }
    }

    fun getFixtures() {
        viewModelScope.launch {
            if (checkFixturesDatabaseForData.invoke() == 0) {
                val response = getFixturesUseCase.invoke()
                response.result.forEach { fixturesData ->
                    insertFixturesUseCase.invoke(fixturesData)
                }
                _fixtures.value = "События загружены"
            }
        }
    }
}