package com.vixonnen.footballtesttask.domain.use_cases

import com.vixonnen.footballtesttask.domain.entity.league.ResultLeagueEntity
import com.vixonnen.footballtesttask.domain.repository.FootballDatabaseRepository
import javax.inject.Inject

class InsertLeaguesUseCase @Inject constructor(
    private val repository: FootballDatabaseRepository
) {

    suspend operator fun invoke(resultLeagueEntity: ResultLeagueEntity) =
        repository.putLeagues(resultLeagueEntity)
}