package com.vixonnen.footballtesttask.data.repository

import com.vixonnen.footballtesttask.data.mappers.toDataEntity
import com.vixonnen.footballtesttask.data.mappers.toEntity
import com.vixonnen.footballtesttask.data.network.Api
import com.vixonnen.footballtesttask.domain.entity.country.DataCountriesEntity
import com.vixonnen.footballtesttask.domain.entity.league.DataEntity
import com.vixonnen.footballtesttask.domain.entity.matches.DataMatchesEntity
import com.vixonnen.footballtesttask.domain.entity.seasons.DataSeasonsEntity
import com.vixonnen.footballtesttask.domain.repository.FootballNetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FootballNetworkRepositoryImpl @Inject constructor(
    private val api: Api
    ) : FootballNetworkRepository {

    override suspend fun getLeagues(): DataEntity =
        withContext(Dispatchers.IO) {
            api.getAllLeagues().toDataEntity()
        }

    override suspend fun getMatches(): DataMatchesEntity =
        withContext(Dispatchers.IO) {
            api.getMatches().toEntity()
        }

    override suspend fun getSeason(): DataSeasonsEntity =
        withContext(Dispatchers.IO) {
            api.getSeason().toEntity()
        }

    override suspend fun getCountry(): DataCountriesEntity =
        withContext(Dispatchers.IO) {
            api.getCountries().toEntity()
        }
}