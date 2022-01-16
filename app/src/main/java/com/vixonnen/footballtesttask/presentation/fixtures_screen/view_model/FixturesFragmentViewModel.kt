package com.vixonnen.footballtesttask.presentation.fixtures_screen.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vixonnen.footballtesttask.domain.entity.fixtures.ResultFixturesEntity
import com.vixonnen.footballtesttask.domain.use_cases.GetFixturesByLeagueUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class FixturesFragmentViewModel @Inject constructor(
    private val getFixturesByLeagueUseCase: GetFixturesByLeagueUseCase
) : ViewModel() {

    private val _fixtures = MutableLiveData<List<ResultFixturesEntity>>()
    val fixtures: LiveData<List<ResultFixturesEntity>> = _fixtures

    fun getFixtures(leagueName: String) {
        viewModelScope.launch {
            _fixtures.value = getFixturesByLeagueUseCase.invoke(leagueName)
        }
    }
}