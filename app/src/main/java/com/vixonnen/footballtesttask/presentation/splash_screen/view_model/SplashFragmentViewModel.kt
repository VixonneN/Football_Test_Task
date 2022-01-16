package com.vixonnen.footballtesttask.presentation.splash_screen.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vixonnen.footballtesttask.domain.use_cases.*
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
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

    //выведение на экран ошибок
    private val _exception = MutableLiveData<String>()
    val exception: LiveData<String> = _exception

    private val handler = CoroutineExceptionHandler { _, throwable ->
        when (throwable) {
            is UnknownHostException -> _exception.value = "UnknownHostException"
            is SocketTimeoutException ->_exception.value = "SocketTimeoutException"
            is HttpException -> {
                when (throwable.code()) {
                    403 -> _exception.value = "Доступ запрещён"
                    404 -> _exception.value = "Ничего не найдено, попробуйте ещё раз"
                }
            }
        }
    }

    fun getLeagues() {
        viewModelScope.launch(handler) {
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
        viewModelScope.launch(handler) {
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