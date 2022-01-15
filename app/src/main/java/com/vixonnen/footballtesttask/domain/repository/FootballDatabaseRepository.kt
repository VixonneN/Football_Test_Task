package com.vixonnen.footballtesttask.domain.repository

import com.vixonnen.footballtesttask.domain.entity.league.ResultLeagueEntity

interface FootballDatabaseRepository {

    suspend fun getLeagues() : List<ResultLeagueEntity>
    suspend fun putLeagues(resultLeagueEntity: ResultLeagueEntity)


}