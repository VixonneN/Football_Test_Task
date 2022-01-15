package com.vixonnen.footballtesttask.domain.use_cases

import com.vixonnen.footballtesttask.domain.entity.league.ResultLeagueEntity
import com.vixonnen.footballtesttask.domain.repository.FootballDatabaseRepository
import javax.inject.Inject

class GetLeaguesFromDatabase @Inject constructor(
    private val repository: FootballDatabaseRepository
) {

    suspend operator fun invoke() : List<ResultLeagueEntity> =
        repository.getLeagues()

}