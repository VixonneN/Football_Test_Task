package com.vixonnen.footballtesttask.domain.repository

import com.vixonnen.footballtesttask.domain.entity.country.DataCountriesEntity
import com.vixonnen.footballtesttask.domain.entity.league.DataEntity
import com.vixonnen.footballtesttask.domain.entity.matches.DataMatchesEntity
import com.vixonnen.footballtesttask.domain.entity.seasons.DataSeasonsEntity

interface FootballNetworkRepository {

    suspend fun getLeagues() : DataEntity
    suspend fun getMatches() : DataMatchesEntity
    suspend fun getSeason() : DataSeasonsEntity
    suspend fun getCountry() : DataCountriesEntity
}