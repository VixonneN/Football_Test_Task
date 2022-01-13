package com.vixonnen.footballtesttask.domain.use_cases

import com.vixonnen.footballtesttask.domain.entity.seasons.DataSeasonsEntity
import com.vixonnen.footballtesttask.domain.repository.FootballNetworkRepository
import javax.inject.Inject

class GetSeasonUseCase @Inject constructor(
    private val repository: FootballNetworkRepository
) {

    suspend operator fun invoke() : DataSeasonsEntity =
        repository.getSeason()
}