package com.vixonnen.footballtesttask.domain.use_cases

import com.vixonnen.footballtesttask.domain.entity.league.DataEntity
import com.vixonnen.footballtesttask.domain.repository.FootballNetworkRepository
import javax.inject.Inject

class GetAllLeaguesUseCase @Inject constructor(
    private val repository: FootballNetworkRepository
) {

    suspend operator fun invoke() : DataEntity =
        repository.getLeagues()
}