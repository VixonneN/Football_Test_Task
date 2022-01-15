package com.vixonnen.footballtesttask.domain.use_cases

import com.vixonnen.footballtesttask.domain.entity.league.DataLeagueEntity
import com.vixonnen.footballtesttask.domain.repository.FootballNetworkRepository
import javax.inject.Inject

class GetLeaguesUseCase @Inject constructor(
    private val repository: FootballNetworkRepository
) {

    suspend operator fun invoke() : DataLeagueEntity =
        repository.getLeagues()
}