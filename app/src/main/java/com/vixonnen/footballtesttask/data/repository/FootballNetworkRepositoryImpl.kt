package com.vixonnen.footballtesttask.data.repository

import com.vixonnen.footballtesttask.data.mappers.toEntity
import com.vixonnen.footballtesttask.data.network.Api
import com.vixonnen.footballtesttask.domain.entity.fixtures.DataFixturesEntity
import com.vixonnen.footballtesttask.domain.entity.league.DataLeagueEntity
import com.vixonnen.footballtesttask.domain.repository.FootballNetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FootballNetworkRepositoryImpl @Inject constructor(
    private val api: Api
    ) : FootballNetworkRepository {

    override suspend fun getLeagues(): DataLeagueEntity =
        withContext(Dispatchers.IO) {
            api.getLeagues().toEntity()
        }

    override suspend fun getFixtures(leagueId: String): DataFixturesEntity =
        withContext(Dispatchers.IO) {
            api.getFixtures(leagueId).toEntity()
        }
}