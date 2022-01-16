package com.vixonnen.footballtesttask.presentation.fixtures_screen.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vixonnen.footballtesttask.domain.entity.fixtures.ResultFixturesEntity
import com.vixonnen.footballtesttask.domain.use_cases.GetFixturesByLeagueUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

class FixturesFragmentViewModel @Inject constructor(
    private val getFixturesByLeagueUseCase: GetFixturesByLeagueUseCase
) : ViewModel() {

    private val _fixtures = MutableLiveData<List<ResultFixturesEntity>>()
    val fixtures: LiveData<List<ResultFixturesEntity>> = _fixtures

    private val _exception = MutableLiveData<String>()
    val exception: LiveData<String> = _exception

    private val handler = CoroutineExceptionHandler { _, throwable ->
        _exception.value = throwable.message
    }

    fun getFixtures(leagueName: String) {
        viewModelScope.launch(handler) {
            _fixtures.value = getFixturesByLeagueUseCase.invoke(leagueName)
        }
    }
}