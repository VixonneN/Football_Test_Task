package com.vixonnen.footballtesttask.domain.repository

import com.vixonnen.footballtesttask.domain.entity.fixtures.DataFixturesEntity
import com.vixonnen.footballtesttask.domain.entity.league.DataLeagueEntity


interface FootballNetworkRepository {

    suspend fun getLeagues(): DataLeagueEntity
    suspend fun getFixtures() : DataFixturesEntity

}