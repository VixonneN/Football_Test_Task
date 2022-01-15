package com.vixonnen.footballtesttask.domain.repository

import com.vixonnen.footballtesttask.data.dto.fixtures.ResultFixturesDTO
import com.vixonnen.footballtesttask.domain.entity.fixtures.ResultFixturesEntity
import com.vixonnen.footballtesttask.domain.entity.league.ResultLeagueEntity

interface FootballDatabaseRepository {

    suspend fun getLeagues() : List<ResultLeagueEntity>
    suspend fun putLeagues(resultLeagueEntity: ResultLeagueEntity)

    suspend fun getFixtures() : List<ResultFixturesEntity>
    suspend fun putFixtures(fixturesEntity: ResultFixturesEntity)
    suspend fun getFixturesByLeague(leagueName: String) : List<ResultFixturesEntity>
}