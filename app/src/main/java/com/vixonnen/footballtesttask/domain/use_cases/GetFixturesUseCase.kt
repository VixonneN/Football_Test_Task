package com.vixonnen.footballtesttask.domain.use_cases

import com.vixonnen.footballtesttask.domain.entity.fixtures.DataFixturesEntity
import com.vixonnen.footballtesttask.domain.repository.FootballNetworkRepository
import javax.inject.Inject

class GetFixturesUseCase @Inject constructor(
    private val repository: FootballNetworkRepository
) {

    suspend operator fun invoke(leagueId: String) : DataFixturesEntity =
        repository.getFixtures(leagueId)
}