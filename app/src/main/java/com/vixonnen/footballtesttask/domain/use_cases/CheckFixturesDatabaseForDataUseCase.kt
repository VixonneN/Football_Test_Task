package com.vixonnen.footballtesttask.domain.use_cases

import com.vixonnen.footballtesttask.domain.repository.FootballDatabaseRepository
import javax.inject.Inject

class CheckFixturesDatabaseForDataUseCase @Inject constructor(
    private val repository: FootballDatabaseRepository
) {

    suspend operator fun invoke() : Int =
        repository.checkFixturesForData()
}