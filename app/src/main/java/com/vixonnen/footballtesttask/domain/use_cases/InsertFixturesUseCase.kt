package com.vixonnen.footballtesttask.domain.use_cases

import com.vixonnen.footballtesttask.domain.entity.fixtures.ResultFixturesEntity
import com.vixonnen.footballtesttask.domain.repository.FootballDatabaseRepository
import javax.inject.Inject

class InsertFixturesUseCase @Inject constructor(
    private val repository: FootballDatabaseRepository
) {

    suspend operator fun invoke(resultFixturesEntity: ResultFixturesEntity) =
        repository.putFixtures(resultFixturesEntity)
}