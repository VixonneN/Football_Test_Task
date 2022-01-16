package com.vixonnen.footballtesttask.presentation.league_screen.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vixonnen.footballtesttask.domain.entity.league.DataLeagueEntity
import com.vixonnen.footballtesttask.domain.entity.league.ResultLeagueEntity
import com.vixonnen.footballtesttask.domain.use_cases.GetLeaguesFromDatabase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

class LeagueFragmentViewModel @Inject constructor(
    private val getLeaguesFromDatabase: GetLeaguesFromDatabase
) : ViewModel() {

    private val _leagues = MutableLiveData<List<ResultLeagueEntity>>()
    val leagues: LiveData<List<ResultLeagueEntity>> = _leagues

    private val _exception = MutableLiveData<String>()
    val exception: LiveData<String> = _exception

    private val handler = CoroutineExceptionHandler { _, throwable ->
        _exception.value = throwable.message
    }

    fun getLeagues() {
        viewModelScope.launch(handler) {
            _leagues.value = getLeaguesFromDatabase.invoke()
        }
    }
}