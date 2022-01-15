package com.vixonnen.footballtesttask.data.repository

import com.vixonnen.footballtesttask.data.data_source.database.FootballDatabase
import com.vixonnen.footballtesttask.data.mappers.toDTO
import com.vixonnen.footballtesttask.data.mappers.toEntity
import com.vixonnen.footballtesttask.domain.entity.league.ResultLeagueEntity
import com.vixonnen.footballtesttask.domain.repository.FootballDatabaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FootballDatabaseRepositoryImpl @Inject constructor(
    private val database: FootballDatabase
) : FootballDatabaseRepository {

    override suspend fun getLeagues(): List<ResultLeagueEntity> =
        withContext(Dispatchers.IO) {
            database.footballDao.getLeagues().toEntity()
        }

    override suspend fun putLeagues(resultLeagueEntity: ResultLeagueEntity) =
        withContext(Dispatchers.IO) {
            database.footballDao.putLeagues(resultLeagueEntity.toDTO())
        }
}