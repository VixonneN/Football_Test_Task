package com.vixonnen.footballtesttask.domain.repository

import com.vixonnen.footballtesttask.domain.entity.league.DataEntity
import com.vixonnen.footballtesttask.domain.entity.matches.DataMatchesEntity

interface FootballNetworkRepository {

    suspend fun getLeagues() : DataEntity
    suspend fun getMatches() : DataMatchesEntity
}